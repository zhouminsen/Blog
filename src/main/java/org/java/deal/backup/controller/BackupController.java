package org.java.deal.backup.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.java.base.common.controller.BaseController;
import org.java.deal.backup.entity.Backup;
import org.java.deal.backup.service.BackupService;
import org.java.util.WebUtil;
import org.java.util.json.JsonUtil;
import org.java.util.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("admin/backup")
@Controller
public class BackupController extends BaseController{
	
	@Resource
	private BackupService backupService;
	
	@RequestMapping(value="list",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String list(HttpServletRequest request) {
		Map<String, Object> queryMap=WebUtil.getParameterMap(request);
		Page<Backup> page=backupService.getPageByCondition(queryMap);
		Map<String, Object> dataMap=new HashMap<String, Object>();
		dataMap.put("total", page.getTotalCount());
		dataMap.put("rows", page.getResultData());
		System.out.println(JsonUtil.parseToJson(dataMap));
		return JsonUtil.parseToJson(dataMap);
	}
	
}