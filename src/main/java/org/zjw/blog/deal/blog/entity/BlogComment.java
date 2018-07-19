package org.zjw.blog.deal.blog.entity;
/**
 * 
 * @author 周家伟
 * @date 2016-7-16
 */
import java.util.Date;

import org.zjw.blog.base.common.entity.BaseEntity;

public class BlogComment extends BaseEntity{
    private Integer id;

    private String userIp;

    private Integer blogId;

    private String content;

    private Date commentDate;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

	@Override
	public String toString() {
		return "TComment [id=" + id + ", userIp=" + userIp + ", blogId="
				+ blogId + ", content=" + content + ", commentDate="
				+ commentDate + ", state=" + state + "]";
	}

	
    
}