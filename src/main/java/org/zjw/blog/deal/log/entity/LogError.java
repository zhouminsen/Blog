package org.zjw.blog.deal.log.entity;

import org.zjw.blog.base.common.entity.BaseEntity;

public class LogError extends BaseEntity {
    private Integer id;

    private String ipAddress;

    private String className;

    private String methodName;

    private String parameter;

    private String exceptionInfo;

    private String sqlContent;

    private String tableName;

    private Integer userId;


    private String moduleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter == null ? null : parameter.trim();
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo == null ? null : exceptionInfo.trim();
    }

    public String getSqlContent() {
        return sqlContent;
    }

    public void setSqlContent(String sqlContent) {
        this.sqlContent = sqlContent == null ? null : sqlContent.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }
}