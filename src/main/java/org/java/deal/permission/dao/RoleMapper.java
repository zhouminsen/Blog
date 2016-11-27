package org.java.deal.permission.dao;


import java.util.List;
import java.util.Map;

import org.java.base.common.dao.BaseDao;
import org.java.base.common.dao.MyBatisRepository;
import org.java.deal.permission.entity.Role;
@MyBatisRepository
public interface RoleMapper extends BaseDao<Role>{
	/**
	 * 根据用户id查询
	 * @param queryMap
	 * @return
	 */
	List<Role> selectByUserId(Map<?, ?> queryMap);
}