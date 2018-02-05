package org.zjw.blog.base.common.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 删除标志
	 */
	private Integer deleteFlag;
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
	
}
