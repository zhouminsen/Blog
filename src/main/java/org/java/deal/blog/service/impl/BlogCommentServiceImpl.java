package org.java.deal.blog.service.impl;

import org.java.base.vo.blog.BlogCommentVo;
import org.java.deal.blog.dao.BlogCommentMapper;
import org.java.deal.blog.dao.BlogMapper;
import org.java.deal.blog.entity.Blog;
import org.java.deal.blog.entity.BlogComment;
import org.java.deal.blog.service.BlogCommentService;
import org.java.util.UtilFuns;
import org.java.util.page.Page;
import org.java.util.page.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;



@Service(value="blogCommentService")
public class BlogCommentServiceImpl implements BlogCommentService {

	@Resource
	private BlogCommentMapper blogCommentMapper;

	@Resource
	private BlogMapper blogMapper;

	public int save(BlogComment comment) throws Exception {
		comment.setCommentDate(new Date());
		comment.setState(0);
		blogCommentMapper.insertSelective(comment);
		Blog blog = blogMapper.selectByPrimaryKey(comment.getBlogId());
		blog.setReplyHit(blog.getReplyHit() + 1);
		return blogMapper.updateByPrimaryKeySelective(blog);
	}


	public Page<BlogCommentVo> getPageVoByCondition(Map<String, Object> queryMap) {
		PageUtil.isEmptySetValue(queryMap);
		if (UtilFuns.isNotEmpty(queryMap.get("state"))) {
			queryMap.put("state", Integer.parseInt((String) queryMap.get("state")));
		}
		Page<BlogCommentVo> page=new Page<BlogCommentVo>((Integer)queryMap.get("currentPage"), (Integer)queryMap.get("rows"));
		queryMap.put("start", page.getStart());
		List<BlogCommentVo> blogCommentVoList=blogCommentMapper.selectVoByCondition(queryMap);
		if (blogCommentVoList.isEmpty()) {
			page.setSuccess(0);
			return page;
		}
		page.setResultData(blogCommentVoList);
		int totalCount=blogCommentMapper.selectVoCountByCondition(queryMap);
		page.setTotalCount(totalCount);
		return page;
	}


	public int deleteLogicBatch(String[] idArray, Integer userId) {
		int[] ids=new int[idArray.length];
		for (int i = 0; i < idArray.length; i++) {
			ids[i]=Integer.parseInt(idArray[i]);
		}
		return blogCommentMapper.deleteLogicBatch(ids);
	}


	public int review(Integer state, String[] idArray) {
		for (int i = 0; i < idArray.length; i++) {
			BlogComment bc=new BlogComment();
			bc.setId(Integer.parseInt(idArray[i]));
			bc.setState(state);
			int line=blogCommentMapper.updateByPrimaryKeySelective(bc);
			if (line<=0) {
				return 0;
			}
		}
		return 1;
	}
}
