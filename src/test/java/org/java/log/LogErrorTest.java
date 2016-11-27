package org.java.log;


import java.util.Date;

import javax.annotation.Resource;

import org.java.base.common.test.BaseTest;
import org.java.deal.log.entity.LogError;
import org.java.deal.log.service.LogErrorService;
import org.java.deal.log.service.LogLoginService;
import org.java.util.page.Page;
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
