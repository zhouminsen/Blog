package org.java.blog;

import java.util.HashMap;
import java.util.Map;

import org.java.base.vo.blog.BlogCommentVo;
import org.java.deal.blog.service.BlogCommentService;
import org.java.util.page.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BlogCommentTest {
	ApplicationContext app=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
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
