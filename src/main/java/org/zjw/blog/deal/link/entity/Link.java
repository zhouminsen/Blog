package org.zjw.blog.deal.link.entity;

import java.util.Date;

import org.zjw.blog.base.common.entity.BaseEntity;

/**
 * 
 * @author 周家伟
 * @date 2016-7-16
 */
public class Link extends BaseEntity {
    private Integer id;

    private String linkName;

    private String linkUrl;

    private Integer orderNo;
    
    private Date createDate;
    
    private Integer deleteFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
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
		return "Link [id=" + id + ", linkName=" + linkName + ", linkUrl="
				+ linkUrl + ", orderNo=" + orderNo + ", createDate="
				+ createDate + ", deleteFlag=" + deleteFlag + "]";
	}


	
}