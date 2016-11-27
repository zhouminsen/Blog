package org.java.base.vo.blog;

import java.util.Date;

import org.java.base.common.entity.BaseEntity;

/**
 * 博客vo
 * 
 * @author 周家伟
 * @date 2016-8-2
 */
public class BlogTypeVo extends BaseEntity{
	private Integer id;

	private String typeName;

	private Integer orderNo;

	private Date createDate;

	private Integer deleteFlag;

	private Integer BlogCount;

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

	public Integer getBlogCount() {
		return BlogCount;
	}

	public void setBlogCount(Integer blogCount) {
		BlogCount = blogCount;
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
		return "BlogTypeVo [id=" + id + ", typeName=" + typeName + ", orderNo="
				+ orderNo + ", createDate=" + createDate + ", deleteFlag="
				+ deleteFlag + ", BlogCount=" + BlogCount + "]";
	}
}
