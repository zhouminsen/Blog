package org.zjw.blog.log;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.zjw.blog.base.common.test.BaseTest;
import org.zjw.blog.deal.log.entity.LogLogin;
import org.zjw.blog.deal.log.service.LogLoginService;
import org.zjw.blog.util.page.Page;
import org.junit.Test;

public class LogLoginTest extends BaseTest {
	@Resource
	private LogLoginService logLoginService;
	
	@Test
	public void getPageByCondition(){
		Map<String, Object> queryMap=new HashMap<String, Object>();
		Page<LogLogin> page=logLoginService.getPageByCondition(queryMap);
		System.out.println(page.getTotalCount());
		for (LogLogin item : page.getResultData()) {
			System.out.println(item);
		}
	}
	
	@Test
	public void delete() {
		System.out.println(logLoginService.deleteLogicBatch(new String[]{"54","55"}));
	}
}
