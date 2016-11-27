package org.java.temp.memcached;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.danga.MemCached.SockIOPool.SockIO;

public class MemCacheInvoke {
	protected static MemCachedClient mc = new MemCachedClient();
	static {
		// 设置缓存服务器列表
		String[] servers = { "127.0.0.1:11211" };
		// 设置服务器权重
		Integer[] weights = { 10 };
		// 创建一个Socked连接池实例
		SockIOPool pool = SockIOPool.getInstance();
		// 向连接池设置服务器和权重
		pool.setServers(servers);
		pool.setWeights(weights);
		// set some TCP settings
		// disable nagle
		// set the read timeout to 3 secs
		// and don't set a connect timeout
		pool.setNagle(false);
		pool.setSocketTO(3000);
		pool.setSocketConnectTO(0);
		// initialize the connection pool
		pool.initialize();
	}

	public static void main(String[] args) {
		// mcc.set("foo3", "This is a test String");
		// mcc.delete("foo");
		// String bar = mcc.get("foo3").toString();
		long startDate = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			mc.add("test" + i, "中国" + i);
		}

		//System.out.print(" get value : " + mc.get("test1"));
		// System.out.println(nowDate);
		// System.out.println("="+mc.statsItems());
		MemCacheInvoke aa = new MemCacheInvoke();
		for (String string : aa.getKeys()) {
			System.out.println(string);
		}
		// System.out.println("aa="+ mc.statsCacheDump(0, 100).toString());
	}

	public List<String> getKeys() {
		List<String> logs = new ArrayList<String>();
		System.out.println(mc.stats());
		System.out.println(" -- end stats --");
		// ArrayList keys = new ArrayList();
		// 取得 所有 memcached server ,可能有多台 server
		Map slabs = mc.statsItems();
		System.out.println(slabs);
		System.out.println(" -- end statsItems --");
		// key= ip:port, ex: 192.168.1.2:11211,192.168.1.2:11212...
		Iterator itemsItr = slabs.keySet().iterator();
		// 以server IP key值去迴圈,可能有多台 server
		while (itemsItr.hasNext()) {
			String serverInfo1 = itemsItr.next().toString();
			// 取得這個server的各種 status [itemname:number:field=value]
			Map itemNames = (Map) slabs.get(serverInfo1);
			Iterator itemNameItr = itemNames.keySet().iterator();
			// 以status key值去迴圈
			while (itemNameItr.hasNext()) {
				String itemName = itemNameItr.next().toString();
				// 拆解status 欄位
				// itemAtt[0] = itemname
				// itemAtt[1] = CacheDump的參數
				// itemAtt[2] = field:number or age
				String[] itemAtt = itemName.split(":");
				// 要取得field為number的CacheDump參數
				if (itemAtt[2].startsWith("number")) {
					// 以status取到的參數,取得cachedDump Map...(下面Map名稱命錯了)
					// ServerIP<cachekey<byte size;unix timestamp>>
					Map chcheDump = mc.statsCacheDump(
							Integer.parseInt(itemAtt[1]), 0);
					// ystem.out.println(chcheDump);
					Iterator itr = chcheDump.keySet().iterator();
					// 以server IP key值去迴圈,可能有多台 server
					int i = 0;
					while (itr.hasNext()) {
						// key=ip:port
						String serverInfo2 = itr.next().toString();
						// 取得Cached Key Map...<-終於,這才是我要的Key集合
						Map items = (Map) chcheDump.get(serverInfo2);
						// System.out.println(items);
						Iterator keyItr = items.keySet().iterator();
						// 以Cached Key 去迴圈,取key出來,或是要取size,unix timestamp 也有
						while (keyItr.hasNext()) {
							String key = keyItr.next().toString();
							String memKey = key;
							i++;
							try {
								key = URLDecoder.decode(key, "UTF-8");
								Object value = items.get(memKey);
								logs.add(key);
							} catch (Exception ex) {
								logs.add("error:" + ex.getMessage());
								// System.out.println("error:" +
								// ex.getMessage());
							}
						}
					}
				}
			}
		}
		return logs;
	}
}