package org.zjw.blog.redis;

import org.zjw.blog.base.common.test.BaseTest;
import org.junit.Test;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

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
