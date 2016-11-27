package org.java.permission;

import org.java.deal.permission.entity.Operation;
import org.java.deal.permission.service.OperationService;
import org.java.util.page.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 权限测试
 * @author Administrator
 * @date 2016-7-29
 */
public class OperationTest {
	ApplicationContext app = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	OperationService operationService=(OperationService) app.getBean("operationService");
	/**
	 * 根据id获得权限
	 */
	@Test
	public void getById() {
		System.out.println(operationService.getById(10000));
	}
	
	@Test
	public void getPageByMenuId() {
		Page<Operation> page=operationService.getPageByMenuId(5);
		System.out.println(page.getTotalCount());
		for (Operation item : page.getResultData()) {
			System.out.println(item);
		}
	}
}
