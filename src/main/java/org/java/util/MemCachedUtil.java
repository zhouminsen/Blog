package org.java.util;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.danga.MemCached.MemCachedClient;

public class MemCachedUtil {
	
	
	/**
	 * 得到服务器中所有key
	 * @return
	 */
	public static List<String> getKeys() {
		MemCachedClient memCachedClient=(MemCachedClient) SpringContextUtil.getBean("memCachedClient");
		List<String> logs = new ArrayList<String>();
		System.out.println(memCachedClient.stats());
		System.out.println(" -- end stats --");
		// ArrayList keys = new ArrayList();
		// 取得 所有 memcached server ,可能有多台 server
		Map slabs = memCachedClient.statsItems();
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
					Map chcheDump = memCachedClient.statsCacheDump(
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
