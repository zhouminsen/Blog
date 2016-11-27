package org.java.base.vo.log;

import java.util.Date;

import org.java.base.common.entity.BaseEntity;

public class LogOperationVo extends BaseEntity{
	private Integer id;

	private String ipAddress;

	private String className;

	private String methodName;

	private String parameter;

	private Integer success;

	private String sqlContent;

	private String tableName;

	private Integer userId;

	private String username;

	private Date createDate;

	private Integer deleteFlag;

	private String moduleName;
	
	private String operationType;
	
	private String operationContent;

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
		this.ipAddress = ipAddress;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
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
		this.sqlContent = sqlContent;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getOperationContent() {
		return operationContent;
	}

	public void setOperationContent(String operationContent) {
		this.operationContent = operationContent;
	}

	@Override
	public String toString() {
		return "LogOperationVo [id=" + id + ", ipAddress=" + ipAddress
				+ ", className=" + className + ", methodName=" + methodName
				+ ", parameter=" + parameter + ", success=" + success
				+ ", sqlContent=" + sqlContent + ", tableName=" + tableName
				+ ", userId=" + userId + ", username=" + username
				+ ", createDate=" + createDate + ", deleteFlag=" + deleteFlag
				+ ", moduleName=" + moduleName + "]";
	}
}
