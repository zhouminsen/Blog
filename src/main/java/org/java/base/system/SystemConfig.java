package org.java.base.system;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class SystemConfig {
	private static Properties systemConfig = new Properties();
	/**
	 * 系统参数配置文件
	 */
	private static final String SYSCFG = "systemConfig";

	static {
		// 读取配置文件
		ResourceBundle bundle = ResourceBundle.getBundle(SYSCFG);
		/*//这种方式也能迭代
		Enumeration<String> el = bundle.getKeys();
		while (el.hasMoreElements()) {
			String keyString = el.nextElement();
			systemConfig.put(keyString, bundle.getString(keyString));
		}*/
		
		Set<String> keys=bundle.keySet();
		for (String key : keys) {
			systemConfig.put(key, bundle.getString(key));
		}
	}

	/**
	 * 拿到所有的配置文件信息
	 * 
	 * @return
	 */
	public static Map<?, ?> getAllConfig() {
		return systemConfig;
	}

	/**
	 * 根据key获得相对应得配置信息value
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return systemConfig.getProperty(key);
	}
}
