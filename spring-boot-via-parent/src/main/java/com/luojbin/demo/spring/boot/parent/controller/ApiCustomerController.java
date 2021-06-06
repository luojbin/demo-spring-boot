package com.luojbin.demo.spring.boot.parent.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("customer")
@Slf4j
public class ApiCustomerController {

    @RequestMapping("get")
    public Map<String, Object> greet(String arg){
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "customer, ok");
        return result;
    }
}
