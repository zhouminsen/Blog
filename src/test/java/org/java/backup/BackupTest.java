package org.java.backup;

import java.util.HashMap;
import java.util.Map;

import org.java.deal.backup.entity.Backup;
import org.java.deal.backup.service.BackupService;
import org.java.util.page.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BackupTest {
	ApplicationContext app=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	BackupService backupService=(BackupService) app.getBean("backupService");
	/**
	 * 多条件查询分页对象
	 */
	@Test
	public void getPageByCondition() {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		Page<Backup> page=backupService.getPageByCondition(queryMap);
		System.out.println(page.getTotalCount());
		for (Backup item : page.getResultData()) {
			System.out.println(item);
		}
	}
}
