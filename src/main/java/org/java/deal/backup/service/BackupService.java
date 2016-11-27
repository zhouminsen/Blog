
package org.java.deal.backup.service;

import java.util.Map;

import org.java.deal.backup.entity.Backup;
import org.java.util.page.Page;



public interface BackupService {
	
	/**
	 * 多条件查询分页对象
	 * @param queryMap
	 * @return
	 */
	Page<Backup> getPageByCondition(Map<String, Object> queryMap);
	
}
