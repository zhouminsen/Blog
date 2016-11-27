package org.java.deal.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.java.base.common.entity.BaseEntity;
/**
 * 
 * @author 周家伟
 * @date 2016-7-16
 */
public class Blog extends BaseEntity{
    private Integer id;

    private String title;

    private String summary;

    private Date releaseDate;

    private Integer clickHit;

    private Integer replyHit;

    private Integer typeId;

    private String keyWord;

    private String content;
    
    private Integer userId;
    
    private Integer state;

	private List<String> imgList=new ArrayList<String>();
    
    
    public Blog() {
		super();
	}

	public Blog(Integer id) {
		super();
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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
    

	public List<String> getImgList() {
		return imgList;
	}

	public void setImgList(List<String> imgList) {
		this.imgList = imgList;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", summary=" + summary
				+ ", releaseDate=" + releaseDate + ", clickHit=" + clickHit
				+ ", replyHit=" + replyHit + ", typeId=" + typeId
				+ ", keyWord=" + keyWord + ", content=" + content + ", userId="
				+ userId + ", state=" + state + ", imgList=" + imgList
				+ ", getCreateDate()=" + getCreateDate() + ", getDeleteFlag()="
				+ getDeleteFlag() + "]";
	}

	
    
}