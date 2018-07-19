package org.zjw.blog.deal.log.entity;

import org.zjw.blog.base.common.entity.BaseEntity;

public class LogOperation extends BaseEntity{
    private Integer id;

    /**
     * 用户ip
     */
    private String ipAddress;

    /**
     * 类名
     */
    private String className;

    /**
     * 方法名称
     */
    private String methodName;
    
    /**
     * 参数
     */
    private String parameter;

    /**
     * 是否成功
     */
    private Integer success;
    
    /**
     * 操作类型
     */
    private String operationType;
    
    /**
     * sql语句
     */
    private String sqlContent;

    /**
     * 数据表名
     */
    private String tableName;

    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 模块名称
     */
    private String moduleName;
    
    /**
     * 操作内容
     */
    private String operationContent;

    public String getOperationContent() {
		return operationContent;
	}

	public void setOperationContent(String operationContent) {
		this.operationContent = operationContent;
	}

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

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
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

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	@Override
	public String toString() {
		return "LogOperation [id=" + id + ", ipAddress=" + ipAddress
				+ ", className=" + className + ", methodName=" + methodName
				+ ", parameter=" + parameter + ", success=" + success
				+ ", operationType=" + operationType + ", sqlContent="
				+ sqlContent + ", tableName=" + tableName + ", userId="
				+ userId + ", moduleName=" + moduleName + ", operationContent="
				+ operationContent + ", getCreateDate()=" + getCreateDate()
				+ ", getDeleteFlag()=" + getDeleteFlag() + "]";
	}
	
}