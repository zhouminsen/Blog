package org.java.deal.baseController.admin;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.java.base.system.MessageConstant;
import org.java.base.system.SystemConfig;
import org.java.base.vo.user.AuthUser;
import org.java.deal.blog.entity.Blogger;
import org.java.deal.blog.service.BloggerService;
import org.java.util.CryptographyUtil;
import org.java.util.DateUtil;
import org.java.util.UtilFuns;
import org.java.util.WebUtil;
import org.java.util.file.FileUtil;
import org.java.util.json.JsonUtil;
import org.jsoup.helper.DataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
/**
 * 
 * @author 周家伟
 * @date 2016-7-21
 * 用户管理controller
 */	
@RequestMapping("admin/user")
@Controller
public class UserController {
	@Resource
	private BloggerService bloggerService;
	
	/**
	 * 跳转到用户修改页面
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request) {
		return "admin/blog/modifyInfo";
	}
	
	/**
	 * 根据id获得用户信息
	 *<br> 原路径:/admin/user/1/getById.shtml 
	 *<br> {id}:代表1 那么@PathVariable("id") Integer id=1
	 * @param id
	 * @param response
	 */
	@RequestMapping("{id}/getById")
	public void getById(@PathVariable("id") Integer id, HttpServletResponse response) {
		Blogger blogger = bloggerService.getById(id);
		// fromObject直接将对象转换json
		JSONObject jsonObject = JSONObject.fromObject(blogger);
		System.out.println("我长什么样啊" + jsonObject);
		WebUtil.write(response, jsonObject);
	}
	
	/**
	 * 修改用户信息
	 * @param blogger
	 * @param response
	 */
	@RequestMapping("modify")
	public void modify(Blogger blogger,HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		int line = bloggerService.modify(blogger);
		if (line >= 1) {
			jsonObject.put("success", true);
			jsonObject.put("message", MessageConstant.MODIFY_SUCCESS);
		} else {
			jsonObject.put("success", false);
			jsonObject.put("message", MessageConstant.MODIFY_ERROR);
		}
		WebUtil.write(response, jsonObject);
	}
	/**
	 * 修改密码
	 * @param newPassword 新密码
	 * @param id	当前登录人id
	 * @param response
	 */
	@RequestMapping("modifyPassword")
	public void modifyPassword(String newPassword,Integer id,HttpServletResponse response){
		JSONObject jsonObject=new JSONObject();
		try {
			AuthUser authUser = (AuthUser) SecurityUtils.getSubject().getPrincipal();
			authUser.getBlogger().setId(id);
			int line = bloggerService.modifyPassword(newPassword,authUser.getBlogger());
			if (line>=1) {
				jsonObject.put("success", true);
				jsonObject.put("message", MessageConstant.MODIFY_SUCCESS);
			}else {
				jsonObject.put("success", false);
				jsonObject.put("message", MessageConstant.MODIFY_ERROR);
			}
			WebUtil.write(response, jsonObject);
		} catch (Exception e) {
			jsonObject.put("success", false);
		}
		System.out.println(jsonObject);
	}
	
	/**
	 * spring上传图片到本地服务器中
	 * @param pic 对应 页面表单中的pic标签
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("uploadPic")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic,
			HttpServletRequest request, HttpServletResponse response)throws IOException {
		// 得到文件后缀
		String suffix=UtilFuns.cutLastStrLater(pic.getOriginalFilename(), ".");
		//拼接文件名
		String fileName=DateUtil.getCurDateStr("yyyyMMddHHssmm")+"."+suffix;
		String filePath=request.getServletContext().getRealPath("/");
		//得到要上传的地址
		filePath+=SystemConfig.getString("user_images");
		File file=FileUtil.createNewFile(filePath, fileName);
		//开始上传
		pic.transferTo(file);
		JSONObject jsonObject=new JSONObject();
		//dataUrl存入数据库的 allUrl该图片的服务器的路径
		jsonObject.put("dataUrl", fileName);
		jsonObject.put("allUrl", SystemConfig.getString("cxt")+SystemConfig.getString("user_images")+"/"+fileName);
		WebUtil.write(response, jsonObject);
	}
	
	/**
	 * Jersey上传图片到外部服务器中
	 * @param pic2  对应 页面表单中的pic2标签
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws IOException
	 */
	@RequestMapping("uploadPicJersey")
	public void uploadPicJersey(@RequestParam(required = false) MultipartFile pic2,
		HttpServletRequest request, HttpServletResponse response) throws Exception {
		AuthUser authUser=(AuthUser) SecurityUtils.getSubject().getPrincipal();
		String str=bloggerService.getUploadImgAuth(authUser);
		if (UtilFuns.isEmpty(str)) {
			throw new Exception("没有改权限");
		}
		Map<String, Object> resultMap = JsonUtil.parseToObject(str, Map.class);
		if (((Integer) resultMap.get("code")) != 200) {
			throw new Exception("没有改权限");
		}
		// 得到文件后缀
		String suffix = UtilFuns.cutLastStrLater(pic2.getOriginalFilename(),".");
		// 拼接文件名
		String fileName = DateUtil.getCurDateStr("yyyyMMddHHssmm") + "."+ suffix;
		 //创建Client对象 注意是 jersey 中的 Client com.sun.jersey.api.client.Client;
		Client client = new Client();
		//服务器地址
		String url = SystemConfig.getString("imageServer_userImage")+"/"+fileName;
		WebResource resource = client.resource(url);
		//发送图片到服务器中
		String put = resource.put(String.class, pic2.getBytes());
		System.out.println(put);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("dataUrl2", fileName);
		jsonObject.put("allUrl2", url);
		WebUtil.write(response, jsonObject);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
