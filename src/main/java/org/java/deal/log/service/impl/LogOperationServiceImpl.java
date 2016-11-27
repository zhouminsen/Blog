
package org.java.deal.log.service.impl;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.java.base.system.SystemConfig;
import org.java.base.vo.log.LogOperationVo;
import org.java.deal.backup.dao.BackupMapper;
import org.java.deal.backup.entity.Backup;
import org.java.deal.blog.dao.BloggerMapper;
import org.java.deal.log.dao.LogLoginMapper;
import org.java.deal.log.dao.LogOperationMapper;
import org.java.deal.log.entity.LogLogin;
import org.java.deal.log.service.LogOperationService;
import org.java.util.DateUtil;
import org.java.util.file.ExportExcelUtil;
import org.java.util.file.FileUtil;
import org.java.util.page.Page;
import org.java.util.page.PageUtil;
import org.springframework.stereotype.Service;

@Service("logOperationService")
public class LogOperationServiceImpl implements LogOperationService {

	@Resource
	private LogOperationMapper logOperationMapper;
	
	@Resource
	private BackupMapper backupMapper;
	
	@Resource
	private BloggerMapper bloggerMapper;

	public Page<LogOperationVo> getPageByCondition(Map<String, Object> queryMap) {
		PageUtil.isEmptySetValue(queryMap);
		Page<LogOperationVo> page = new Page<LogOperationVo>(
				(Integer)queryMap.get("currentPage"),
				(Integer)queryMap.get("rows"));
		queryMap.put("start", page.getStart());
		List<LogOperationVo> logOperationList =logOperationMapper.selectVoByCondition(queryMap);
		int totalCount = logOperationMapper.selectVoCountByCondition(queryMap);
		page.setTotalCount(totalCount);
		page.setResultData(logOperationList);
		return page;
	}

	public void backup(Map<String, Object> queryMap) throws Exception {
		PageUtil.isEmptySetValue(queryMap);
		Backup backup=new Backup();
		//当前模块名加上日期
		String fileName="操作日志"+DateUtil.getCurDateStr("yyyyMMddHHmmss");
		backup.setBackupName(fileName);
		backup.setBackupPath("/backup/log/operation/"+fileName+".xls");
		backup.setBackupType("操作日志");
		backup.setCreateDate(new Date());
		backupMapper.insertSelective(backup);
		// 设置总标题
		String brow = "登录日志";
		// 每列的标题栏
		String[] titleRow = { "操作人", "ip地址", "操作类", "方法名称", "方法参数", "操作类型",
				"操作时间", "操作模块" };
		List<String[]> bodyRow = new ArrayList<String[]>();
		List<LogOperationVo> voList = logOperationMapper.selectVoByCondition(queryMap);
		for (LogOperationVo item : voList) {
			// 设置每行的显示文字
			String[] row = {
					item.getUsername(),
					item.getIpAddress(),
					item.getClassName(),
					item.getMethodName(),
					item.getParameter(),
					item.getOperationType(),
					DateUtil.dateToStr(item.getCreateDate(),DateUtil.NORMALPATTERN), 
					item.getModuleName() };
			bodyRow.add(row);
		}
		String filePath = SystemConfig.getString("backup")+ "/log/operation";
		File file=FileUtil.createNewFile(filePath,fileName+".xls");
		OutputStream out=new FileOutputStream(file);
		ExportExcelUtil.createExcel(out, brow, titleRow, bodyRow, null);
	}

	public int deleteLogicBatch(String[] idArray) {
		List<Integer> ids=new ArrayList<Integer>();
		for (String id : idArray) {
			ids.add(Integer.parseInt(id));
		}
		return logOperationMapper.deleteLogicBatch(ids);
	}
	
}
