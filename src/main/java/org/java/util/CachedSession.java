package org.java.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.danga.MemCached.MemCachedClient;
/**
 * 缓冲的的session
 * @author 周家伟
 * @date 2016-9-1
 */
public class CachedSession {
	
	@Resource
	private MemCachedClient memCachedClient;
	
	/**
	 * 用户的sessionId
	 */
	private static final String JSESSIONID="JSESSIONID";
	/**
	 * 有效时间
	 */
	private int expiry=30;
	
	/**
	 * 获取值
	 * <br>将当前用户的sessionId作为缓存中的key,获得缓存中报的数据map 在将name作为map中key进行取值
	 * @param request
	 * @param response
	 * @param name
	 * @return
	 */
	public Serializable getAttribute(HttpServletRequest request,HttpServletResponse response,String name) {
		String key=getSessionId(request, response);
		Map<String, Serializable> sessionMap=(Map<String, Serializable>) memCachedClient.get(key);
		if (sessionMap!=null) {
			return sessionMap.get(name);
		}
		return null;
	}
	
	/**
	 * 设置值
	 * <br>将当前用户的sessionId作为key. 参数name,value形式存储到map中 再将 key和map存入到缓存中
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 */
	public void setAttribute(HttpServletRequest request,HttpServletResponse response,String name,Serializable value) {
		Map<String, Serializable> sessionMap=new HashMap<String, Serializable>();
		sessionMap.put(name, value);
		String key=getSessionId(request, response);
		memCachedClient.set(key, sessionMap);
	}
	
	/**
	 * 退出登录 并该用户所存储的cooike删除
	 * @param request
	 * @param response
	 */
	public void logout(HttpServletRequest request,HttpServletResponse response) {
		String key=getSessionId(request, response);
		//如果存在该key删除并且将该cookie立即销毁
		if (memCachedClient.keyExists(key)) {
			memCachedClient.delete(key);
			Cookie[] cookies = request.getCookies();
			if (cookies!=null) {
				for (Cookie c : cookies) {
					if (JSESSIONID.equals(c.getName())) {
						c.setMaxAge(0);
						return;
					}
				}
			}
		}
	}
	
	/**
	 * 获得sessionId
	 * <br>从cookies中寻找该sessionId,如果没则设置一个添加都cookie中
	 * @param request
	 * @param response
	 * @return
	 */
	public String getSessionId(HttpServletRequest request,HttpServletResponse response) {
		//拿到所有的cookie
		Cookie[] cookies=request.getCookies();
		if (cookies!=null) {
			for (Cookie c : cookies) {
				//如果存在则直接返回
				if (JSESSIONID.equals(c.getName())) {
					return c.getValue();
				}
			}
		}
		//不存在,生成以sessionId
		String uuId=UUID.randomUUID().toString().replaceAll("-", "");
		Cookie cookie=new Cookie(JSESSIONID,uuId);
		cookie.setPath("/");
		cookie.setMaxAge(expiry);
		response.addCookie(cookie);
		return uuId;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
