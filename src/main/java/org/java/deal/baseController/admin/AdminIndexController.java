package org.java.deal.baseController.admin;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.shiro.SecurityUtils;
import org.java.base.common.controller.BaseController;
import org.java.base.vo.user.AuthUser;
import org.java.deal.blog.entity.Blogger;
import org.java.deal.log.entity.LogLogin;
import org.java.deal.log.service.LogLoginService;
import org.java.deal.permission.service.RoleService;
import org.java.util.FTPUtil;
import org.java.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

@Controller
@RequestMapping("admin")
public class AdminIndexController extends BaseController{
	
	@Resource
	private LogLoginService logLoginService;
	
	@Resource
	private RoleService roleService;

	@Resource
	private FTPUtil ftpUtil;
	
	@RequestMapping("first")
	public String index(HttpServletRequest request) throws IOException {
		AuthUser authUser=(AuthUser) SecurityUtils.getSubject().getPrincipal();
		System.out.println(SecurityUtils.getSubject().isRemembered()+"第三大萨达萨达萨达速度");
		System.out.println(SecurityUtils.getSubject().isAuthenticated()+"第三大萨达萨达萨达速度");
		request.getServletContext().removeAttribute("init");
		FTPClient ftp = new FTPClient();
		ftp.connect(ftpUtil.getFtpHost(), ftpUtil.getFtpPort());
		if (!ftp.login(ftpUtil.getFtpUserName(), ftpUtil.getFtpPassword())) {
			ftp.disconnect();
		}
//		AuthUser authUser=(AuthUser) request.getSession().getAttribute("currentUser");
		Blogger blogger=authUser.getBlogger();
		LogLogin logLogin=new LogLogin();
		logLogin.setCreateDate(new Date());
		logLogin.setIpAddress(WebUtil.getIpAddr(request));
		logLogin.setDescription("普通登录成功");
		logLogin.setPassword(blogger.getPassword());
		logLogin.setUsername(blogger.getUsername());
		logLogin.setType(1);
		logLogin.setStatus(1);
		logLoginService.save(logLogin);
		Set<String> permissionList=roleService.getPermissionsByUserId(authUser.getId());
		request.getSession().setAttribute("permissionList", permissionList);
		return "/admin/main";
	}
}
