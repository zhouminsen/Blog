package org.zjw.blog.blog;

import java.util.HashMap;
import java.util.Map;

import org.zjw.blog.base.vo.blog.BlogTypeVo;
import org.zjw.blog.deal.blog.service.BlogTypeService;
import org.zjw.blog.util.page.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BlogTypeTest {
	ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
	BlogTypeService blogTypeService=(BlogTypeService) app.getBean("blogTypeService");
	
	/**
	 * 多条件查询vo分页对象
	 */
	@Test
	public void getPageVoByCondition() {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("startDate", "2016-8-1");
		queryMap.put("endDate", "2016-8-5");
		queryMap.put("typeName", null);
		Page<BlogTypeVo> page=blogTypeService.getPageVoByCondition(queryMap);
		System.out.println(page.getTotalCount());
		for (int i = 0; i < page.getResultData().size(); i++) {
			System.out.println(page.getResultData().get(i));
		}
	}

	
}
