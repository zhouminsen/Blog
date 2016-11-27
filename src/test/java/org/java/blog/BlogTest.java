package org.java.blog;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.java.base.common.test.BaseTest;
import org.java.base.lucene.BlogLucene;
import org.java.base.vo.blog.BlogLuceneVo;
import org.java.base.vo.blog.BlogVo;
import org.java.deal.blog.entity.Blog;
import org.java.deal.blog.entity.BlogComment;
import org.java.deal.blog.service.BlogService;
import org.java.util.SpringContextUtil;
import org.java.util.page.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 测试blog
 * @author 周家伟
 * @date 2016-7-29
 */
public class BlogTest extends BaseTest{
	
	@Resource
	private BlogService blogService;
	
	/**
	 * 复原批数据
	 */
	@Test
	public void restoreBatch() {
		String[] ids={};
		int line=blogService.restoreBatch(ids,1);
		System.out.println(line);
	}
	
	/**
	 * 查询博文给后台用
	 */
	@Test
	public void getPageByConditionToBack() {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("order", "ddd");
		if (queryMap.get("order")!=null) {
			queryMap.put("sort", "releaseDate");
			queryMap.put("order", "asc");
		}
		Page<BlogVo> page=blogService.getPageByConditionToBack(queryMap);
		System.out.println(page.getTotalCount());
		for (BlogVo item : page.getResultData()) {
			System.out.println(item.getReleaseDateStr());
			System.out.println(item.getBlogType());
		}
	}
	
	/**
	 * 插入数据
	 */
	@Test
	public void save() {
		Blog blog=new Blog();
		blog.setKeyWord("haha");
		blog.setReleaseDate(new Date());
		blog.setSummary("dsdsd");
		blog.setContent("dsadasdasd");
		int line=blogService.save(blog);
		System.out.println(blog);
	}

}
