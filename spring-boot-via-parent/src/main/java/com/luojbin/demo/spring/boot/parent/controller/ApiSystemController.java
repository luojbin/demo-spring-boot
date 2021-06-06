package com.luojbin.demo.spring.boot.parent.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("system")
@Slf4j
public class ApiSystemController {

    @RequestMapping("log")
    public Map<String, Object> greet(String arg){
        log.info("system 获取到请求，参数 {}", arg);
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "system, ok");
        return result;
    }
}
