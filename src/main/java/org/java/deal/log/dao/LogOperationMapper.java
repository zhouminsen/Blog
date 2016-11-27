package org.java.deal.log.dao;


import java.util.List;
import java.util.Map;

import org.java.base.common.dao.BaseDao;
import org.java.base.common.dao.MyBatisRepository;
import org.java.base.vo.log.LogOperationVo;
import org.java.deal.log.entity.LogOperation;
@MyBatisRepository
public interface LogOperationMapper extends BaseDao<LogOperation>{
	/**
	 * 多条件查询vo
	 * @param queryMap
	 * @return
	 */
	List<LogOperationVo> selectVoByCondition(Map<String, Object> queryMap);
	
	/**
	 * 多条件查询vo记录数
	 * @param queryMap
	 * @return
	 */
	int selectVoCountByCondition(Map<String, Object> queryMap);
}