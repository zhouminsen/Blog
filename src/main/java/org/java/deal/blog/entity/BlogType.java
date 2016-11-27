package org.java.deal.blog.entity;


import org.java.base.common.entity.BaseEntity;

/**
 * 
 * @author 周家伟
 * @date 2016-7-16
 */
public class BlogType extends BaseEntity {
	private Integer id;

	private String typeName;

	private Integer orderNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName == null ? null : typeName.trim();
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	@Override
	public String toString() {
		return "BlogType [id=" + id + ", typeName=" + typeName + ", orderNo="
				+ orderNo + ", getCreateDate()=" + getCreateDate()
				+ ", getDeleteFlag()=" + getDeleteFlag() + "]";
	}

}