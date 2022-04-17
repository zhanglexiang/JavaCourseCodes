package com.xiang.config;

import lombok.Data;

import java.io.Serializable;

/*** 
 * 动态数据源用户
 * @author zlx 
 */
@Data
public class DynamicUser implements Serializable {

    /***
     * 企业id
     */
    private Long companyId;

    /***
     * 数据源名称
     */
    private String dataSourceName;

    /***
     * mycat schma
     */
    private String schema;

    public DynamicUser() {
    }

    public DynamicUser(Long companyId, String dataSourceName, String schema) {
        this.companyId = companyId;
        this.dataSourceName = dataSourceName;
        this.schema = schema;
    }

}
