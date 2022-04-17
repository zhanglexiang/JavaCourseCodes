package com.xiang.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dangdang.ddframe.rdb.sharding.api.MasterSlaveDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static com.xiang.enums.DatasourceEnum.DEFAULT_DATASOURCE;
import static com.xiang.enums.DatasourceEnum.MYCAT_DATASOURCE;


/**
 * @author zlx
 * @Description: 分表数据源配置
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = DEFAULT_DATASOURCE)
    public DataSource defaultDataSource() {

        // 主从库配置
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(DEFAULT_DATASOURCE,
                createDataSource(readwriteProperties()), //主库
                createDataSource(read1Properties()) //从库1
        );

        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("joinf_trade", dataSource);

        DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap);

        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(dataSourceRule)
                .build();

        return ShardingDataSourceFactory.createDataSource(shardingRule);
    }

    /***
     * mycat数据源
     * @author zlx
     */
    @Bean(name = MYCAT_DATASOURCE)
    public DataSource mycatDataSource() {
        return createDataSource(mycat1Properties());
    }

    @Bean
    @ConfigurationProperties(prefix = "sharding.jdbc.datasource.master")
    public DruidDataSourceProperties readwriteProperties() {
        return new DruidDataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "sharding.jdbc.datasource.slave0")
    public DruidDataSourceProperties read1Properties() {
        return new DruidDataSourceProperties();
    }

    /***
     * mycat数据源
     * @author zlx
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.mycat-1")
    public DruidDataSourceProperties mycat1Properties() {
        return new DruidDataSourceProperties();
    }

    /***
     * 数据源共用配置
     * @author zlx
     */
    @Bean
    @ConfigurationProperties(prefix = "sharding.jdbc.datasource")
    public DatasourceProperties commonProperties() {
        return new DatasourceProperties();
    }


    /**
     * 创建数据源
     *
     * @return {@link DataSource}
     * @param: properties
     * @author zlx
     */
    private DataSource createDataSource(DruidDataSourceProperties properties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());

        DatasourceProperties commonProperties = commonProperties();

        dataSource.setDriverClassName(commonProperties.getDriverClassName());
        dataSource.setInitialSize(commonProperties.getInitialSize());
        dataSource.setMinIdle(commonProperties.getMinIdle());
        dataSource.setMaxActive(commonProperties.getMaxActive());
        dataSource.setMaxWait(commonProperties.getMaxWait());
        dataSource.setValidationQuery(commonProperties.getValidationQuery());
        dataSource.setPoolPreparedStatements(commonProperties.getPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(commonProperties.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            dataSource.setFilters(commonProperties.getFilters());
        } catch (SQLException e) {
        }
        dataSource.setConnectionProperties(commonProperties.getConnectionProperties());
        return dataSource;
    }

    @Bean("dynamicDataSource")
    @Primary
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DEFAULT_DATASOURCE, defaultDataSource());
        dataSourceMap.put(MYCAT_DATASOURCE, mycatDataSource());

        // 设置默认数据源
        dynamicDataSource.setDefaultDataSource(defaultDataSource());

        dynamicDataSource.setDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
        return new DataSourceTransactionManager(dynamicDataSource());
    }


}
