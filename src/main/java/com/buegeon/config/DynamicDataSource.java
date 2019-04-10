package com.buegeon.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 设置数据源自动调用该类方法
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("数据源为" + DataSourceContextHolder.getDB());
        //从共享线程中获取数据源名称
        return DataSourceContextHolder.getDB();
    }

}