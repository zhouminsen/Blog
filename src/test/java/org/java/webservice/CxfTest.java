package org.java.webservice;

import java.util.List;





import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.java.base.common.test.BaseTest;
import org.java.base.cxf.imageServer.interceptor.AddHeaderInterceptor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CxfTest extends BaseTest{
	/*@Resource(name="helloWorld")
	private HelloWorld helloWorld;*/
	
	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext.xml");
		 
	}
}
