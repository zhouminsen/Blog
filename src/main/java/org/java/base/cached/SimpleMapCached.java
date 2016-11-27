package org.java.base.cached;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.apache.cxf.common.util.CollectionUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

public class SimpleMapCached implements Cache<Object, Object>,Serializable{
	
	private  Map<Object, Object> attributes;
	private  String name;
	
	

	public SimpleMapCached(Map<Object, Object> attributes, String name) {
		if (name==null) {
			 throw new IllegalArgumentException("Cache name cannot be null.");  
		}
		if (attributes==null) {
			throw new IllegalArgumentException("attributes map cannot be null.");
		}
		this.attributes = attributes;
		this.name = name;
	}

	public Object get(Object key) throws CacheException {
		return attributes.get(key);
	}

	public Object put(Object key, Object value) throws CacheException {
		return attributes.put(key, value);
	}

	public Object remove(Object key) throws CacheException {
		return attributes.remove(key);
	}

	public void clear() throws CacheException {
		attributes.clear();
	}

	public int size() {
		return attributes.size();
	}

	public Set<Object> keys() {
		Set<Object> keySet = attributes.keySet();
		if (!keySet.isEmpty()) {
			return Collections.unmodifiableSet(keySet);
		}
		return Collections.emptySet();
	}

	public Collection<Object> values() {
		Collection<Object> values = attributes.values();
		if (CollectionUtils.isEmpty(values)) {
			return Collections.unmodifiableCollection(values);
		}
		return Collections.emptySet();
	}
	
	public String toString() {  
        return (new StringBuilder("SimpleMapCache '")).append(name).append("' (").append(attributes.size()).append(  
                " entries)").toString();  
    }  

}
