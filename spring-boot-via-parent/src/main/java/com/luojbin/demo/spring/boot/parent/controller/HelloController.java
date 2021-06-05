package com.luojbin.demo.spring.boot.parent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("hello")
    public String hello(Model model){
        model.addAttribute("msg", "测试获取信息");
        return "hello2";
    }
}
