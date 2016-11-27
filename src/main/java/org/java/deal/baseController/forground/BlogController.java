package org.java.deal.baseController.forground;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.java.base.common.controller.BaseController;
import org.java.base.system.MessageConstant;
import org.java.base.system.SystemConfig;
import org.java.base.vo.blog.BlogLuceneVo;
import org.java.base.vo.blog.BlogVo;
import org.java.deal.blog.entity.Blog;
import org.java.deal.blog.service.BlogService;
import org.java.util.WebUtil;
import org.java.util.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/blog")
@Controller
public class BlogController extends BaseController {

	@Resource
	private BlogService blogService;

	/**
	 * 搜索博客
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/search")
	public String searchBlog(HttpServletRequest request) {
		Map<String, Object> queryMap = WebUtil.getParameterMap(request);
		try {
			Page<BlogLuceneVo> page = blogService.getPageBykeyword(queryMap);
			if (page.getResultData().isEmpty()) {
				// 如果没有找到数据提示信息
				request.setAttribute("dataEmptyMsg",MessageConstant.SEARCHDATA_EMPTY);
			}
			request.setAttribute("page", page);
			request.setAttribute("blogList", page.getResultData());
			request.setAttribute("keyword", queryMap.get("keyword"));
			request.setAttribute("displayPage", "/foreground/blog/result.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "foreground/main";
	}

	/**
	 * 查看博客详情信息
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String detail(HttpServletRequest request,
			@PathVariable("id") Integer id) {
		//ModelAndView mav = new ModelAndView();
		BlogVo blogVo = blogService.getVoById(id);
		request.setAttribute("blog", blogVo);
		request.setAttribute("commentList", blogVo.getCommentList());
		request.setAttribute("displayPage", "/foreground/blog/view.jsp");
		//mav.setViewName("foreground/main");
		return "foreground/main";
	}

}