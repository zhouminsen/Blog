package org.zjw.blog.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring容器工具
 * @author 周家伟
 * <br>该类配置在applicationContext.xml中
 */
public class SpringContextUtil implements ApplicationContextAware {
	private static ApplicationContext context;
	
	private static final Logger log = LoggerFactory.getLogger(SpringContextUtil.class);

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextUtil.context = applicationContext;
	}

	public static Object getBean(String beanName) {
		Object o = context.getBean(beanName);
		return o;
	}

	public static <T> T getBean(String name, Class<T> clazz) {
		T bean = context.getBean(name, clazz);
		return bean;
	}

	public static Map<String, ?> getBeansByType(Class<?> clazz) {
		Map<String, ?> beans = context.getBeansOfType(clazz);
		return beans;
	}

}
