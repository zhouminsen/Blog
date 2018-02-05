package org.zjw.blog.user;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.zjw.blog.deal.log.entity.LogLogin;
import org.zjw.blog.deal.log.service.LogLoginService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 日志测试
 * @author Administrator
 *
 */
public class LogTest {
	ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
	LogLoginService logLoginService=(LogLoginService) app.getBean("logLoginService");
	/**
	 * 添加登录日志
	 */
	@Test
	public void addLogLogin() {
		LogLogin logLogin=new LogLogin();
		logLogin.setCreateDate(new Date());
		logLogin.setIpAddress("12345");
		//1代表普通登录
		logLogin.setType(1);
		//0代表登录失败
		logLogin.setStatus(0);
		logLogin.setUsername("zjw");
		logLogin.setPassword("123");
		logLogin.setDescription("登录失败");
		logLoginService.save(logLogin);
	}
	/**
	 * 查询登录日志
	 */
	@Test
	public void searchLogLogin() {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("ipAddress", "12345");
		System.out.println(logLoginService.getByIp(queryMap).size());
	}
}
