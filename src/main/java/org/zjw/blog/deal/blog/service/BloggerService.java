
package org.zjw.blog.deal.blog.service;


import org.zjw.blog.base.vo.user.AuthUser;
import org.zjw.blog.deal.blog.entity.Blogger;

public interface BloggerService {
	
	/**
	 * 根据id查旭
	 * @param id
	 * @return
	 */
	Blogger getById(Integer id);
	
	/**
	 * 修改密码
	 * @param newPassword 新密码
	 * @param blogger 用户
	 * @return
	 */
	int modifyPassword(String newPassword, Blogger blogger);

	/**
	 * 修改用户
	 * @param blogger
	 * @param isChangePic
     * @return
	 */
	int modify(Blogger blogger, Integer isChangePic);
	
	/**
	 * 从imageServer里获得上传图片的权限
	 * <br>获得上传图片的权限
	 * <br>返回成功示例:{"code":200,"message":"你有该权限"}
	 * @param authUser
	 * @return
	 */
	String getUploadImgAuth(AuthUser authUser);
}
