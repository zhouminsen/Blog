package org.java.base.cached;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

public class ShiroCachedManager implements CacheManager, Destroyable{
	
	 private SimpleCachedManager simpleCachedManager;  
	  
	    public Cache<Object, Object> getCache(String name) throws CacheException {  
	        return simpleCachedManager.getCache(name);  
	    }  
	  
	    public void destroy() throws Exception {  
	        simpleCachedManager.destroy();  
	    }  
	  
	    public SimpleCachedManager getSimpleCacheManager() {  
	        return simpleCachedManager;  
	    }  
	  
	    public void setSimpleCacheManager(SimpleCachedManager simpleCacheManager) {  
	        this.simpleCachedManager = simpleCacheManager;  
	    }  
	  
}
