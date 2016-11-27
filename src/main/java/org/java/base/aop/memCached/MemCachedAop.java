package org.java.base.aop.memCached;

import com.danga.MemCached.MemCachedClient;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.java.util.MemCachedUtil;
import org.java.util.json.JsonUtil;

import javax.annotation.Resource;
import java.util.List;
/**
 * memcached切面
 * @author 周家伟
 * @date 2016-8-25
 */
public class MemCachedAop {
	@Resource
	private MemCachedClient memCachedClient;

	private int expir = 90000000;

	/**
	 * 对查询方法进行切面,环绕通知
	 * <br>对于查询的方法,只要进行了非增删改的操作,数据全部进入mencached中
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		// 如果没有连接到memcached服务器
		if (memCachedClient.stats().isEmpty()) {
			System.out.println("Memcached服务器可能不存在或是连接不上");
			return pjp.proceed();
		}
		// 拿到key
		String key = getCachedKey(pjp);
		System.out.println("memcached.key.length"+key.length());
		// 如果缓存中没有该key则进行存储
//		if (memCachedClient.get(key) == null) {
			Object object = pjp.proceed();
			memCachedClient.set(key, object, expir);
//		}
		return memCachedClient.get(key);
	}
	
	/**
	 * 对增删改的操作进行切面,后置通知
	 * <br>为了保持缓存中的数据与数据库中的数据统一性,如果做了增删改的操作,就把缓存中该类所对应的缓存全部删除
	 * @param jp
	 * @param result
	 */
	public void doAfterReturn(JoinPoint jp,Object result) {
		String key=jp.getTarget().getClass().getName();
		List<String> keyList = MemCachedUtil.getKeys();
		for (String item : keyList) {
			if (item.startsWith(key)) {
				memCachedClient.delete(item);
			}
		}
	}

	/**
	 * 获得CacheKey 
	 * <br>生成CacheKey的策略:全路径类名+方法名+参数列表
	 * <br>在utf-8编码下最多只能能容乃145字节长度,超过了该长度memcached不储存
	 * @param pjp
	 * @return {@link String}
	 */
	private String getCachedKey(ProceedingJoinPoint pjp) {
		StringBuilder sb = new StringBuilder();
		// 获得全路径类名
		String className = pjp.getTarget().getClass().getName();
		// 获得方法名
		String methodName =pjp.getSignature().getName();
		// 获得方法中的参数
		Object[] args = pjp.getArgs();
		String param = JsonUtil.parseToJson(args);
		sb.append(className).append(".").append(methodName).append(".").append(param);
		if (sb.length()>=146) {
			return sb.substring(0, 145);
		}
		return sb.toString();
	}
}
