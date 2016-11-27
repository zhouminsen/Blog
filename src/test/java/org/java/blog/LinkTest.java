package org.java.blog;

import java.util.HashMap;
import java.util.Map;

import org.java.deal.link.entity.Link;
import org.java.deal.link.service.LinkService;
import org.java.util.page.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LinkTest {
	ApplicationContext app=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	LinkService linkService=(LinkService) app.getBean("linkService");
	
	/**
	 * 查询分页对象链接
	 */
	@Test
	public void getPage() {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		Page<Link> page=linkService.getPage(queryMap);
		System.out.println(page.getTotalCount());
		for (Link link : page.getResultData()) {
			System.out.println(link);
		}
	}
}		
