package org.zjw.blog.freemarker;

import java.util.HashMap;
import java.util.Map;




import javax.annotation.Resource;

import org.zjw.blog.base.common.test.BaseTest;
import org.zjw.blog.util.FreemarkerUitl;
import org.junit.Test;


public class FreemarkerTest extends BaseTest {
	
	@Resource
	private FreemarkerUitl freemarkerUitl;
	
	@Test
	public void create() throws Exception {
		Map<String, Object> dataMap=new HashMap<String, Object>();
		dataMap.put("bb", "周家伟");
		freemarkerUitl.createTemp("D:/WorkSpace/MyEclipse2014_workSpace/Blog/src/main/webapp", dataMap, 1+"");
		System.out.println("ok");
	}
}
