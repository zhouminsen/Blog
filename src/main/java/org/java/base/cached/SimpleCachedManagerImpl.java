package org.java.base.cached;

import javax.annotation.Resource;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import com.danga.MemCached.MemCachedClient;

public class SimpleCachedManagerImpl implements SimpleCachedManager{
	@Resource
	private MemCachedClient memCachedClient;
	
    public SimpleCachedManagerImpl(MemCachedClient memcachedClient) {  
        if (memcachedClient == null) {  
            throw new RuntimeException("必须存在memcached客户端实例");  
        }  
        this.memCachedClient = memcachedClient;  
    }  

    public void createCache(String name, Cache<Object, Object> cache) throws CacheException {  
        try {  
            memCachedClient.set(name, cache);  
        } catch (Exception e) {  
            throw new CacheException(e);  
        }  
    }  
  
    public Cache<Object, Object> getCache(String name) throws CacheException {  
        try {  
            return (Cache<Object, Object>) memCachedClient.get(name);  
        } catch (Exception e) {  
            throw new CacheException(e);  
        }  
    }  
  
    public void removeCache(String name) throws CacheException {  
        try {  
            memCachedClient.delete(name);  
        } catch (Exception e) {  
            throw new CacheException(e);  
        }  
    }  
  
    public void updateCahce(String name, Cache<Object, Object> cache) throws CacheException {  
        try {  
            memCachedClient.replace(name, cache);  
        } catch (Exception e) {  
            throw new CacheException(e);  
        }  
    }  
  
    public void destroy() throws CacheException {  
        try {  
            //memCachedClient.
        } catch (Exception e) {  
            throw new CacheException(e);  
        }  
    }  
  
}  
	
