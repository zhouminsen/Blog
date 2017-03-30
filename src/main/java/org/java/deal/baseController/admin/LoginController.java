package org.java.deal.baseController.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.java.base.common.controller.BaseController;
import org.java.base.filter.JVMCache;
import org.java.base.system.support.ServletAPI;
import org.java.deal.log.entity.LogLogin;
import org.java.deal.log.service.LogLoginService;
import org.java.util.UtilFuns;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.Utils;

@Controller
public class LoginController extends BaseController{
	
	@Resource
	private LogLoginService logLoginService;
	/**
	 * @param logLogin
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("login")
	public String login(LogLogin logLogin) throws Exception {
		System.out.println("excuse me");
		UsernamePasswordToken token=new UsernamePasswordToken(logLogin.getUsername(), logLogin.getPassword());
		if (UtilFuns.isNotEmpty(request.getParameter("remember"))) {
			token.setRememberMe(true);
		}
		SecurityUtils.getSubject().login(token);
		return "forward:/admin/first.shtml";
	}
	
	/**
	 * 该方法为测试的时候用admin.shtml即可自动登录到系统
	 * 如果是在程序内部使用已转发的形式跳到不同url,shiro是不会进行过滤的
	 * 如果是已重定向的方式shiro会进行过滤的
	 * @return
	 */
	@RequestMapping("login2")
	public String login2() {
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("zjw","zjw");
		subject.login(token);
		return "redirect:/admin/first.shtml";
	}
	
	/**
	 * 退出
	 */
	@RequestMapping("admin/logout")
	public String logout(HttpSession session) {
		Subject subject=SecurityUtils.getSubject();
		subject.getSession().stop();
		//session.invalidate();
		return "redirect:/admin/login.jsp";
	}
}
