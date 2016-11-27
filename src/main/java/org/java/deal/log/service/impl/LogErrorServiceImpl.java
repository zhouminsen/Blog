package org.java.deal.log.service.impl;


import javax.annotation.Resource;

import org.java.deal.log.dao.LogErrorMapper;
import org.java.deal.log.entity.LogError;
import org.java.deal.log.service.LogErrorService;
import org.springframework.stereotype.Service;

@Service("logErrorService")
public class LogErrorServiceImpl implements LogErrorService {

	@Resource
	private LogErrorMapper logErrorMapper;
	
	
	public int save(LogError logError) {
		return logErrorMapper.insertSelective(logError);
	}

}
