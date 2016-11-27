package org.java.deal.permission.dao;


import java.util.List;

import org.java.base.common.dao.BaseDao;
import org.java.base.common.dao.MyBatisRepository;
import org.java.deal.permission.entity.Operation;
@MyBatisRepository
public interface OperationMapper extends BaseDao<Operation>{
	
	/**
	 * 根据菜单id获得操作权限
	 * @param menuId
	 * @return
	 */
	List<Operation> selectByMenuId(Integer menuId);
	
	/**
	 * 根据菜单id查询记录数
	 * @param menuId
	 * @return
	 */
	int selectCountByMenuId(Integer menuId);
	
}