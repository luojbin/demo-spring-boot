package com.luojbin.demo.spring.boot.parent.controller;

import com.luojbin.demo.spring.boot.parent.model.Clazz;
import com.luojbin.demo.spring.boot.parent.model.MyAppConstants;
import com.luojbin.demo.spring.boot.parent.model.Student;
import com.luojbin.demo.spring.boot.parent.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/demo")
@RestController
@Slf4j
public class DemoController {

    private DemoService service;

    private final MyAppConstants myAppConstants;

    @Autowired
    public DemoController(MyAppConstants myAppConstants, DemoService service) {
        this.myAppConstants = myAppConstants;
        this.service = service;
    }

    @RequestMapping("world")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("all")
    public List<Clazz> all() {
        List<Clazz> all = service.getAll();
        all.forEach(System.out::println);
        return all;
    }

    @RequestMapping("/exp")
    @ResponseBody
    public String saveStudentWithRtExp() {
        int result = 0;
        try {
            result = service.saveStudentThrowRTExp();
        } catch (Exception e) {
            log.info("运行时异常, 保存失败 {} 个, 异常原因 {}", result, e.getMessage());
        }
        return "运行时异常, 事务回滚 runtimeExp. rollback ok";
    }

    @RequestMapping("/ok")
    @ResponseBody
    public String saveStudent() {
        int result = service.saveStudent();
        log.info("事务提交, 顺利保存对象 {} 个", result);
        return "事务提交 commit ok";
    }

}
