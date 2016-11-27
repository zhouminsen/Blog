package org.java.deal.link.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.java.deal.link.dao.LinkMapper;
import org.java.deal.link.entity.Link;
import org.java.deal.link.service.LinkService;
import org.java.util.page.Page;
import org.java.util.page.PageUtil;
import org.springframework.stereotype.Service;

@Service("linkService")
public class LinkServiceImpl implements LinkService {

	@Resource
	private LinkMapper linkMapper;

	public List<Link> getAll() {
		return linkMapper.selectAll();
	}

	public Page<Link> getPage(Map<String, Object> queryMap) {
		PageUtil.isEmptySetValue(queryMap);
		Page<Link> page = new Page<Link>((Integer) queryMap.get("currentPage"),
				(Integer) queryMap.get("rows"));
		queryMap.put("start", page.getStart());
		List<Link> linkList=linkMapper.selectByCondition(queryMap);
		page.setResultData(linkList);
		int totalCount=linkMapper.selectCountByCondition(queryMap);
		page.setTotalCount(totalCount);
		return page;
	}

	public int deleteLogic(String[] arrayId) {
		Integer[] ids=new Integer[arrayId.length];
		for (int i = 0; i < ids.length; i++) {
			ids[i]=Integer.parseInt(arrayId[i]);
		}
		return linkMapper.deleteLogicBatch(ids);
	}

	public int save(Link link) {
		return linkMapper.insert(link);
	}

	public int modify(Link link) {
		return linkMapper.updateByPrimaryKeySelective(link);
	}
	
	
}
