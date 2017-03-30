package org.java.redis;

import org.java.base.common.test.BaseTest;
import org.java.util.RedisUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zhoum on 2017/2/21.
 */
public class RedisTest2 extends BaseTest {
    @Resource
    private StringRedisTemplate redisTemplate;

    /**
     * redis存储字符串
     */
    @Test
    public void testString() {
        //-----添加数据----------
        redisTemplate.opsForValue().set("name","shenme");//向key-->name中放入了value-->xinxin
        System.out.println(redisTemplate.opsForValue().get("name"));//执行结果：xinxin

        /*jedis.append("name", " is my lover"); //拼接
        System.out.println(jedis.get("name"));

        jedis.del("name");  //删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name","liuling","age","23","qq","476777XXX");
        jedis.incr("age"); //进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));*/

    }
}
