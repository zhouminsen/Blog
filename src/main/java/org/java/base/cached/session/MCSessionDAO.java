package org.java.base.cached.session;

import com.danga.MemCached.MemCachedClient;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * 当进入项目时,shiro会为自动的创建session,并调用该类的doCreate()方法将shiro创建的session存储到memcached中,
 * <br>以后每次用到session都会调用该类的doReadSession()从memcached中进行获取
 * @author 周家伟
 * @date 2016-9-2
 */
public class MCSessionDAO extends AbstractSessionDAO{
	
	private MemCachedClient memCachedClient;
	
	public  MCSessionDAO(MemCachedClient memCachedClient) {
		  if (memCachedClient == null) {  
	            throw new RuntimeException("必须存在memcached客户端实例");  
	        } 
		this.memCachedClient=memCachedClient;
	}

	public void update(Session session) throws UnknownSessionException {
		memCachedClient.replace(session.getId().toString(), session,new Date(session.getTimeout()));
	}

	public void delete(Session session) {
		memCachedClient.delete(session.getId().toString());
	}

	public Collection<Session> getActiveSessions() {
		return Collections.emptySet();
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		memCachedClient.set((String) session.getId(), session,new Date(session.getTimeout()));
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		return (Session) memCachedClient.get(sessionId.toString());
	}

}
