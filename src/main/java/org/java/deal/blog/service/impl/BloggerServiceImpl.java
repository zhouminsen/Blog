package org.java.deal.blog.service.impl;


import javax.annotation.Resource;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.java.base.cxf.imageServer.interceptor.AddHeaderInterceptor;
import org.java.base.vo.user.AuthUser;
import org.java.deal.blog.dao.BloggerMapper;
import org.java.deal.blog.entity.Blogger;
import org.java.deal.blog.service.BloggerService;
import org.java.util.CryptographyUtil;
import org.java.webservice.permission.service.UploadImageService;
import org.java.webservice.permission.service.UploadImageServiceImplService;
import org.springframework.stereotype.Service;

@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

	@Resource
	private BloggerMapper bloggerMapper;
	
	public Blogger getById(Integer id) {
		return bloggerMapper.selectByPrimaryKey(id);
	}

	public int modifyPassword(String newPassword,Blogger blogger) {
		//md5加盐 加密 
		newPassword=CryptographyUtil.md5(newPassword,blogger.getUsername());
		blogger.setPassword(newPassword);
		return bloggerMapper.updateByPrimaryKeySelective(blogger);
	}

	public int modify(Blogger blogger) {
		return bloggerMapper.updateByPrimaryKeySelective(blogger);
	}

	public String getUploadImgAuth(AuthUser authUser) {
		UploadImageServiceImplService service=new UploadImageServiceImplService();
		UploadImageService uploadImageService=service.getUploadImageServiceImplPort();
		Client client=ClientProxy.getClient(uploadImageService);
		client.getOutInterceptors().add(new AddHeaderInterceptor(authUser.getId().toString())); // 添加自定义拦截器
		client.getInInterceptors().add(new LoggingInInterceptor()); // 添加In拦截器 日志拦截器
		client.getOutInterceptors().add(new LoggingOutInterceptor()); // 添加Out拦截器 日志拦截器
		String str=uploadImageService.getUploadAuth(0);
		return str;
	}

}
