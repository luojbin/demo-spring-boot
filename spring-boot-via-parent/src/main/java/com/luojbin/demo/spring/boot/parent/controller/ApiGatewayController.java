package com.luojbin.demo.spring.boot.parent.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("gateway")
@Slf4j
public class ApiGatewayController {

    @RequestMapping("go")
    public Map<String, Object> greet(String arg){
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "gateway, ok");
        return result;
    }
}
