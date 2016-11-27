package org.java.deal.blog.dao;

import java.util.List;
import java.util.Map;

import org.java.base.common.dao.BaseDao;
import org.java.base.common.dao.MyBatisRepository;
import org.java.base.vo.blog.BlogVo;
import org.java.deal.blog.entity.Blog;
@MyBatisRepository
public interface BlogMapper extends BaseDao<Blog>{

    /**
	 * 查询日期下当前博客数量
	 * @return
	 */
	List<Map<String, Object>> selectDateCountByReleaseDate();
	

	/**
	 * 根据id查询并且获得对象实体属性
	 * @param id
	 * @return
	 */
	Blog selectVoById(Integer id);
	
	/**
	 * 插入博文返回
	 * @param blog
	 * @return
	 */
	int insertSelectiveReturn(Blog blog);
	
	/**
	 * 多条件查询博文
	 * @param queryMap
	 * @return
	 */
	List<BlogVo> selectByConditionToBack(Map<?, ?> queryMap);

	/**
	 * 多条件查询博文记录数
	 * @param queryMap
	 * @return
	 */
	int selectCountByConditionToBack(Map<?, ?> queryMap);
}