package com.luojbin.demo.spring.boot.redis.controller;

import com.luojbin.demo.spring.boot.common.entity.Clazz;
import com.luojbin.demo.spring.boot.redis.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Cacheable("all")
    @RequestMapping("all")
    public List<Clazz> all() {
        List<Clazz> all = service.getAll();
        all.forEach(System.out::println);
        return all;
    }

}
