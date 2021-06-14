package com.luojbin.demo.spring.boot.parent;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedissonTest {

    @Autowired
    RedissonClient redis;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testGetSet() {
        RBucket<String> testSet = redis.getBucket("hello");
        testSet.set("redisson");

        // RBucket<String> testGet = redissonClient.getBucket("testGet");
        // System.out.println(testGet.get());

        RSet<String> langSet = redis.getSet("lang");
        langSet.add("java");
        langSet.add("python");
        langSet.add("js");
        langSet.add("php");

        RList<String> rList = redis.getList("langList");
        rList.add("java");
        rList.add("python");
        rList.add("js");
        rList.add("php");

        // RMap<String, String> rMap = redis.getMap("myMap");
        // rMap.put("name", "tom");
        // rMap.put("age", "30");
        // rMap.put("city", "gz");

        RMap<String, String> map2 = redis.getMap("myMap");
        System.out.println(map2.get("name"));
        System.out.println(map2.get("age"));
        System.out.println(map2.get("city"));
        System.out.println(map2.getName());

    }

    @Test
    public void testSetString() {
        RBucket<String> testSet = redis.getBucket("test-get");
        testSet.set("set value ok");
    }

    @Test
    public void testGetString() {
        RBucket<String> testGet = redis.getBucket("test-get");
        assertEquals("set value ok", testGet.get());

    }


}
