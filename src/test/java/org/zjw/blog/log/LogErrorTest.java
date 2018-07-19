package org.zjw.blog.log;


import java.util.Date;

import javax.annotation.Resource;

import org.zjw.blog.base.common.test.BaseTest;
import org.zjw.blog.deal.log.entity.LogError;
import org.zjw.blog.deal.log.service.LogErrorService;
import org.junit.Test;

public class LogErrorTest extends BaseTest{
	@Resource
	private LogErrorService logErrorService;
	
	@Test
	public void save() {
		LogError logError=new LogError();
		logError.setClassName("dsdasd");
		logError.setCreateDate(new Date());
		logError.setIpAddress("dsds");
		int line=logErrorService.save(logError);
		System.out.println(line);
	}
	
}
