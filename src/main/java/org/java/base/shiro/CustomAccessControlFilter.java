package org.java.base.shiro;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.java.base.filter.JVMCache;
import org.java.deal.log.service.LogLoginService;
import org.java.util.UtilFuns;
import org.java.util.WebUtil;

public class CustomAccessControlFilter extends AccessControlFilter {

	@Resource
	private LogLoginService logLoginService;

	/**
	 * 只要是以/**= authc映射的路径都会进入此路径,但不包含之前已被设定的路径 return true 表示放行该次请求 return
	 * false 进入到onAccessDenied()方法里
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		Subject subject = getSubject(request, response);
		if (!subject.isAuthenticated()) {
			return false;
		}
		return true;
	}

	/**
	 * 如果以上没有重定向的话 return true 表示放行该请求 return false
	 * 表示该次请求不做任何响应,也不跳进方法里,而且shiro给我返回客户端的响应状态码为200
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		redirectToLogin(request, response);
		return false;
	}

}
