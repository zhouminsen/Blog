package org.java.deal.log.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.java.base.common.controller.BaseController;
import org.java.base.system.SystemConfig;
import org.java.deal.log.entity.LogLogin;
import org.java.deal.log.service.LogLoginService;
import org.java.deal.log.util.LogUtil;
import org.java.util.WebUtil;
import org.java.util.file.DownloadUtil;
import org.java.util.file.ExportExcelUtil;
import org.java.util.json.JsonLibUtil;
import org.java.util.json.JsonUtil;
import org.java.util.page.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("admin/log/login")
@Controller
public class LogLoginController  extends BaseController{
	
	@Resource
	private LogLoginService logLoginService;
	
	@RequestMapping("index")
	public String index(){
		return "admin/log/logLogin";
	}
	
	@RequestMapping("list")
	public void list(HttpServletResponse response,HttpServletRequest request) {
		Map<String, Object> queryMap=WebUtil.getParameterMap(request);
		Page<LogLogin> page=logLoginService.getPageByCondition(queryMap);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", JsonLibUtil.parseToJson(page.getResultData()));
		jsonObject.put("total", page.getTotalCount());
		WebUtil.write(response, jsonObject);
	}
	
	@RequestMapping("delete")
	public void delete(String ids, HttpServletResponse response) {
		String[] idArray = ids.split(",");
		int line = logLoginService.deleteLogicBatch(idArray);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (line >= 1) {
			resultMap.put("success", true);
			resultMap.put("delNums", idArray.length);
		} else {
			resultMap.put("success", false);
			resultMap.put("errorMsg", "删除数据失败");
		}
		WebUtil.write(response, JsonUtil.parseToJson(resultMap));
	}
	
	
	/**
	 * 后台日志下载
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("downloadLog")
	public ResponseEntity<byte[]> downloadLog(HttpServletResponse response) throws Exception {
		//日志文件路径
		File file=new File(LogUtil.logPath);
		HttpHeaders headers=new HttpHeaders();
		String filename=new String("log.log".getBytes("UTF-8"), "iso-8859-1");
		headers.setContentDispositionFormData("attachment", filename);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return  new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
	}
	
	/**
	 * poi操作excel
	 * 备份excel
	 * @return
	 * @throws Exception
	 */	
	@RequestMapping("backup")
	public void backup(HttpServletResponse response,HttpServletRequest request) throws Exception {
		Map<String, Object> queryMap=WebUtil.getParameterMap(request);
		logLoginService.backup(queryMap);
		//logLoginService.exportExcel(queryMap, response);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("success", true);
		WebUtil.write(response, jsonObject);
	}
	
	/**
	 * 下载备份
	 * @param response
	 * @param fileName
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("downloadBackup")
	public void downloadBackup(HttpServletResponse response,String fileName) throws UnsupportedEncodingException {
		fileName=URLDecoder.decode(fileName, "utf-8");
		String filePath=SystemConfig.getString("backup")+ "/log/login/"+fileName+".xls";
		File file=new File(filePath);
		DownloadUtil downloadUtil=new DownloadUtil();
		downloadUtil.prototypeDownload(file, fileName+".xls", response, false);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
