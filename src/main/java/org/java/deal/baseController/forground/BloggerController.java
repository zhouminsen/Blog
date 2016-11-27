package org.java.deal.baseController.forground;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.base.common.controller.BaseController;
import org.java.deal.blog.entity.Blogger;
import org.java.deal.blog.service.BloggerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blogger")
public class BloggerController extends BaseController{
	
	@Resource
	private BloggerService bloggerService;
	
	@RequestMapping("/aboutMe")
	public String aboutMe(HttpServletRequest request,Integer id) {
		Blogger blogger=bloggerService.getById(1);
		request.setAttribute("blogger", blogger);
		request.setAttribute("displayPage", "/foreground/blogger/info.jsp");
		request.setAttribute("title", "关于博主");
		return "foreground/main";
	}
	
}