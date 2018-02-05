package org.zjw.blog.deal.permission.entity;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable{
    private Integer operationId;

    private String operationName;

    private Integer menuId;

    private String menuName;

    private Date createDate;

    private Integer deleteFlag;

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
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

	@Override
	public String toString() {
		return "Operation [operationId=" + operationId + ", operationName="
				+ operationName + ", menuId=" + menuId + ", menuName="
				+ menuName + ", createDate=" + createDate + ", deleteFlag="
				+ deleteFlag + "]";
	}
    
}