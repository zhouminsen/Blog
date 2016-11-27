package org.java.others;

import javax.servlet.ServletContext;

import org.java.base.system.support.ServletAPI;
import org.junit.Test;

public class RequestAPITest {
	
	@Test
	public void test() {
		System.out.println(ServletAPI.getRequest());
		
	}
}
