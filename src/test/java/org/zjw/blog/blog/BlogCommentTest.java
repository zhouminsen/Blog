package org.zjw.blog.blog;

import java.util.HashMap;
import java.util.Map;

import org.zjw.blog.base.vo.blog.BlogCommentVo;
import org.zjw.blog.deal.blog.service.BlogCommentService;
import org.zjw.blog.util.page.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BlogCommentTest {
	ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
	BlogCommentService blogCommentService=(BlogCommentService) app.getBean("blogCommentService");
	
	@Test
	public void getVoByCondition() {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("userId", 1);
		Page<BlogCommentVo> page=blogCommentService.getPageVoByCondition(queryMap);
		System.out.println(page.getTotalCount());
		for (BlogCommentVo item : page.getResultData()) {
			System.out.println(item);
		}
	}
}
