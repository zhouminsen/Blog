package org.zjw.blog.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerUitl {

	@Resource
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	
	//http://localhost:8080/Blog/blog/detail/71.shtml
	
	public  void createTemp(String path,Map<String, Object> dataMap,String fileName) throws IOException, TemplateException {
		//拿到模板地址
		Template template=freeMarkerConfigurer.createConfiguration().getTemplate("blogDetail.html");
		//创建文件夹
		File file=new File(path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		//将文件夹写入流里
		Writer out=new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
		template.process(dataMap, out);
	}


	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}
	
	
}
