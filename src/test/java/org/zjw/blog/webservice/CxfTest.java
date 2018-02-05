package org.zjw.blog.webservice;


import org.zjw.blog.base.common.test.BaseTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CxfTest extends BaseTest {
	/*@Resource(name="helloWorld")
	private HelloWorld helloWorld;*/
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");
		 
	}
}
