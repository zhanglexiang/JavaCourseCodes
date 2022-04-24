package com.xiang.config;


import com.xiang.enums.DatasourceEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<DynamicUser> contextHolder = new InheritableThreadLocal<DynamicUser>() {
        @Override
        protected DynamicUser initialValue() {
            //返回 默认数据源
            return new DynamicUser(null, DatasourceEnum.DEFAULT_DATASOURCE, null);
        }
    };


    /**
     * 数据源的 key集合，用于切换时判断数据源是否存在
     */
    public static List<Object> dataSourceKeys = new ArrayList<>();

    /**
     * 切换数据源
     * @param dynamicUser
     */
    public static void setDataSourceKey(DynamicUser dynamicUser) {
        contextHolder.set(dynamicUser);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String getDataSourceKey() {
        DynamicUser dynamicUser = getDataSourceUser();
        return dynamicUser != null ? dynamicUser.getDataSourceName() : null;
    }

    /**
     * 获取企业id
     * @return
     */
    public static Long getDataSourceCompanyId() {
        DynamicUser dynamicUser = getDataSourceUser();
        return dynamicUser != null ? dynamicUser.getCompanyId() : null;
    }

    /**
     * 获取数据源
     * @return
     */
    public static DynamicUser getDataSourceUser() {
        return contextHolder.get();
    }

    /**
     * 重置数据源
     */
    public static void clearDataSource() {
        contextHolder.remove();
    }

    /**
     * 判断是否包含数据源
     *
     * @param key 数据源key
     * @return
     */
    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }

    /**
     * 添加数据源keys
     *
     * @param keys
     * @return
     */
    public static boolean addDataSourceKeys(Collection<?> keys) {
        return dataSourceKeys.addAll(keys);
    }
}
