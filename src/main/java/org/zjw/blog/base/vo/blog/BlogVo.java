package org.zjw.blog.base.vo.blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zjw.blog.base.common.entity.BaseEntity;
import org.zjw.blog.deal.blog.entity.BlogComment;
import org.zjw.blog.deal.blog.entity.BlogType;

/**
 * @author 周家伟
 * @date 2016-7-20
 */
public class BlogVo extends BaseEntity {
	private Integer id;

	private String title;

	private String summary;

	private Date releaseDate;

	private String releaseDateStr;

	private Integer clickHit;

	private Integer replyHit;

	private Integer typeId;

	private String keyWord;

	private String content;

	private BlogType blogType;

	private Integer userId;

	private Integer deleteFlag;
	
	private Integer state;

	private List<BlogComment> commentList = new ArrayList<BlogComment>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary == null ? null : summary.trim();
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getClickHit() {
		return clickHit;
	}

	public void setClickHit(Integer clickHit) {
		this.clickHit = clickHit;
	}

	public Integer getReplyHit() {
		return replyHit;
	}

	public void setReplyHit(Integer replyHit) {
		this.replyHit = replyHit;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord == null ? null : keyWord.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public BlogType getBlogType() {
		return blogType;
	}

	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}

	public List<BlogComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<BlogComment> commentList) {
		this.commentList = commentList;
	}

	public String getReleaseDateStr() {
		return releaseDateStr;
	}

	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "BlogVo [id=" + id + ", title=" + title + ", summary=" + summary
				+ ", releaseDate=" + releaseDate + ", releaseDateStr="
				+ releaseDateStr + ", clickHit=" + clickHit + ", replyHit="
				+ replyHit + ", typeId=" + typeId + ", keyWord=" + keyWord
				+ ", content=" + content + ", blogType=" + blogType
				+ ", commentList=" + commentList + "]";
	}

}