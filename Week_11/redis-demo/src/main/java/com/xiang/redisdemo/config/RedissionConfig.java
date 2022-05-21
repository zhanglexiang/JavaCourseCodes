package com.xiang.redisdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * Redission配置类
 */
@Slf4j
@Configuration
public class RedissionConfig {

    @Bean
    public RedissonClient redissonClient(RedisProperties redisProperties) {
        Config config = new Config();
        // 添加主从配置
        MasterSlaveServersConfig slaveConfig = config.useMasterSlaveServers();
        slaveConfig.setMasterAddress("https://"+ redisProperties.getHost() + ":" + redisProperties.getPort());
        if(!StringUtils.isEmpty(redisProperties.getPassword())){
            slaveConfig.setPassword(redisProperties.getPassword());
        }
        RedissonClient client = Redisson.create(config);
        return client;
    }
}
