package org.zjw.blog.permission;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.zjw.blog.base.common.test.BaseTest;
import org.zjw.blog.deal.permission.entity.Role;
import org.zjw.blog.deal.permission.service.RoleService;
import org.zjw.blog.util.page.Page;
import org.junit.Test;

public class RoleTest extends BaseTest {
	@Resource
	private RoleService roleService;
	
	/**
	 * 多条查询分页对象
	 */
	@Test
	public void getPageVoByCondition() {
		Map<String, Object> queryMap=new HashMap<String, Object>();
		Page<Role> page =roleService.getPageByCondition(queryMap);
		System.out.println(page.getTotalCount());
		for (Role item : page.getResultData()) {
			System.out.println(item);
		}
	}
	
}
