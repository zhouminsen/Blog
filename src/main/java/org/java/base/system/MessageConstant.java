package org.java.base.system;

import org.java.base.system.initialize.InitMessage;

/**
 * 
 * @author 周家伟
 * @date 2016-7-17
 * 消息常量值
 */
public class MessageConstant {
	/**
	 * 账户名不存在
	 */
	public static final String UNKNOWN_ACCOUNT=InitMessage.getString("unknownAccount");
	
	/**
	 * 密码错误
	 */
	public static final String PASSWORD_ERROR=InitMessage.getString("passwordError");
	
	/**
	 * 验证码为空
	 */
	public static final String	VERIFYCODE_EMPTY=InitMessage.getString("verifyCodeEmpty");
	
	/**
	 * 验证码错误
	 */
	public static final String	VERIFYCODE_ERROR=InitMessage.getString("verifyCodeError");

	/**
	 * 未知错误
	 */
	public static final String	UNKNOWN_ERROR=InitMessage.getString("unknownError");
	
	/**
	 * 搜索数据为空
	 */
	public static final String	SEARCHDATA_EMPTY=InitMessage.getString("searchDataEmpty");
	
	/**
	 * 账户名不能为空
	 */
	public static final String	USERNAME_EMPTY=InitMessage.getString("usernameEmpty");
	
	/**
	 * 密码不能为空
	 */
	public static final String	PASSWORD__EMPTY=InitMessage.getString("passwordEmpty");
	
	/**
	 * 删除失败
	 */
	public static final String	DELETE_ERROR=InitMessage.getString("deleteError");
	
	/**
	 * 修改失败
	 */
	public static final String	MODIFY_ERROR=InitMessage.getString("modifyError");

	/**
	 * 添加失败
	 */
	public static final String	SAVE_ERROR=InitMessage.getString("saveError");

	/**
	 * 删除成功
	 */
	public static final String	DELETE_SUCCESS=InitMessage.getString("deleteSuccess");

	/**
	 * 修改成功
	 */
	public static final String	MODIFY_SUCCESS=InitMessage.getString("modifySuccess");

	/**
	 * 添加成功
	 */
	public static final String	SAVE_SUCCESS=InitMessage.getString("saveSuccess");

	
	
	
	
	
	
}
