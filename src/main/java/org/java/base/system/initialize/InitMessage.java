package org.java.base.system.initialize;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import org.java.base.system.MessageConstant;
/**
 * 初始化消息数据
 * @author Administrator
 *
 */
public class InitMessage {
	
	private static final String MESSAGE="message";
	private static Properties properties=new Properties();
	static{
		ResourceBundle bundle=ResourceBundle.getBundle(MESSAGE);
		Enumeration<String> enumeration=bundle.getKeys();
		while (enumeration.hasMoreElements()) {
			String key = (String) enumeration.nextElement();
			String value=bundle.getString(key);
			properties.put(key, value);
		}
	}
	
	public static Map<?, ?> getAll() {
		return properties;
	}
	
	public static String getString(String key) {
		return properties.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(MessageConstant.PASSWORD_ERROR);
	}
}
