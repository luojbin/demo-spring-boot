package com.luojbin.demo.spring.boot.redis.controller;

import com.luojbin.demo.spring.boot.common.entity.Clazz;
import com.luojbin.demo.spring.boot.redis.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 注解 RestController 相当于 @Controller 和 @ResponseBody 的结合
 *
 * @author luojbin
 * @version 1.0
 * @date 2019/7/30 17:05
 */
@RequestMapping("/student")
@RestController
@Slf4j
public class StudentController {

    private StudentService service;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("world")
    public String helloWorld() {
        redisTemplate.boundValueOps("hello").set("world");
        return "hello world";
    }

    /**
     * 无参时, 使用空白的 SimpleKey
     * key = "empty::SimpleKey []"
     * @return
     */
    @RequestMapping("empty")
    @Cacheable(cacheNames = "empty")
    public String empty() {
        return "hello empty";
    }

    /**
     * 一个参数时, 使用这个参数
     * key = one::13579
     * @param id 13579
     * @return
     */
    @RequestMapping("one")
    @Cacheable(cacheNames = "one")
    public String one(String id) {
        return "hello one";
    }

    /**
     * 多参数时, 使用包含所有参数的 SimpleKey
     * key = multi::SimpleKey [123,246,cool]
     * @param one 123
     * @param two 246
     * @param three cool
     * @return
     */
    @RequestMapping("multi")
    @Cacheable(cacheNames = "multi")
    public String multi(String one, String two, String three) {
        return "hello multi";
    }
    /**
     * 多参数时, 使用spring 表达式构造 key
     * key = multi::one=123&two=246
     * @param one 123
     * @param two 246
     * @param three cool
     * @return
     */
    @RequestMapping("spel")
    @Cacheable(cacheNames = "spel", key = "'one=' + #one + '&two=' + #two")
    public String spel(String one, String two, String three) {
        return "hello spel";
    }

    /**
     * 先检查缓存, 如果有直接返回
     * 如果缓存未命中, 执行具体方法, 并将结果缓存
     * 后续不需重复执行, 可以直接返回
     * @return
     */
    @Cacheable(cacheNames = "all@PT10M")
    @RequestMapping("all")
    public List<Clazz> all() {
        List<Clazz> all = service.getAll();
        all.forEach(System.out::println);
        return all;
    }

}
