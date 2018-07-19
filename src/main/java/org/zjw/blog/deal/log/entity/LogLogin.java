package org.zjw.blog.deal.log.entity;


import org.zjw.blog.base.common.entity.BaseEntity;

public class LogLogin extends BaseEntity {
    private Integer id;

    private String username;

    private String password;

    private Integer status;

    private Integer type;

    private String description;

    private String ipAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

	@Override
	public String toString() {
		return "LogLogin [id=" + id + ", username=" + username + ", password="
				+ password + ", status=" + status + ", type=" + type
				+ ", description=" + description + ", ipAddress=" + ipAddress
				+ ", getCreateDate()=" + getCreateDate() + ", getDeleteFlag()="
				+ getDeleteFlag() + "]";
	}
    
}