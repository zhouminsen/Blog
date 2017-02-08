package org.java.deal.blog.entity;

import java.io.Serializable;

import org.java.base.common.entity.BaseEntity;
import org.java.base.system.SystemConfig;
import org.java.base.system.UserConstant;

/**
 * 
 * @author 周家伟
 * @date 2016-7-16
 */
public class Blogger extends BaseEntity {
    private Integer id;

    private String username;

    private String password;

    private String nickName;

    private String sign;

    private String imageName;

    private String profile;
    
    private String subImageName;
    
    
    /**
     * 获得头像图片全路径
     * @return
     */
    public String getAllUrl() {
		return SystemConfig.getString("cxt")+SystemConfig.getString("user_images")+"/"+imageName;
	}
    
    /**
     * 获得副头像全路径
     * @return
     */
    public String getSubAllUrl() {
		return UserConstant.USER_IMAGE_ADDR+"/"+username+"/"+subImageName;
	}

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
		this.username = username;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

	public String getSubImageName() {
		return subImageName;
	}

	public void setSubImageName(String subImageName) {
		this.subImageName = subImageName;
	}

	@Override
	public String toString() {
		return "Blogger [id=" + id + ", username=" + username + ", password="
				+ password + ", nickName=" + nickName + ", sign=" + sign
				+ ", imageName=" + imageName + ", profile=" + profile
				+ ", subImageName=" + subImageName + ", getCreateDate()="
				+ getCreateDate() + ", getDeleteFlag()=" + getDeleteFlag()
				+ "]";
	}
	
}