package org.java.deal.log.dao;

import java.util.List;
import java.util.Map;

import org.java.base.common.dao.BaseDao;
import org.java.base.common.dao.MyBatisRepository;
import org.java.deal.log.entity.LogLogin;
/**
 * 
 * @author 周家伟
 * @date 2016-7-18
 * @description 登录日志Mapper
 */
@MyBatisRepository
public interface LogLoginMapper extends BaseDao<LogLogin> {
	/**
	 * 根据ip地址查询login日志
	 * 
	 * @param ip
	 * @return
	 */
	List<LogLogin> selectByIp(Map<String, Object> queryMap);

}