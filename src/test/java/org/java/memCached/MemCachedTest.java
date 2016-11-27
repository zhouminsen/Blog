package org.java.memCached;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.java.base.common.test.BaseTest;
import org.java.util.MemCachedUtil;
import org.junit.Test;

import com.danga.MemCached.MemCachedClient;
/**
 * 
 * @author 周家伟
 * @date 2016-8-25
 */
public class MemCachedTest extends BaseTest{
	
	@Resource
	private MemCachedClient memCachedClient;
	
	/**
	 * 测试memCached添加读取
	 */
	@Test
	public void set() {
		memCachedClient.set("\n", "-1");
		System.out.println(memCachedClient.get("\n"));
		System.out.println(memCachedClient.get("2"));
	}
	
	/**
	 * 删除所有的值 --清空缓存
	 */
	@Test
	public void deleteAll() {
		List<String> keyList = MemCachedUtil.getKeys();
		for (String key : keyList) {
			memCachedClient.delete(key);
		}
	}

	@Test
	public void get() {
		System.out.println(memCachedClient.get("17f54aa6-d1f4-4eae-8e51-39fdab051123"));
	}
	
	/**
	 * 删除指定的值
	 */
	@Test
	public void delete() {
		memCachedClient.delete("");
	}
}
