package com.luojbin.demo.spring.boot.dependencies;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private MeterRegistry meterRegistry;

    static List<String> list = new ArrayList();

    @GetMapping("world/{name}")
    public User helloUser(@PathVariable("name") String name) {
        User u = new User();
        u.setName(name);
        u.setAge(18);
        return u;
    }

    @GetMapping("count/{name}")
    public List<String> count(@PathVariable("name") String name){
        list.add(name);
        meterRegistry.gaugeCollectionSize("my.metrics.count", Tags.empty(), list);
        meterRegistry.gauge("my.metrics.last", System.currentTimeMillis());
        return list;
    }

    static class User {
        private String name;
        private Integer age;

        //region getter/setter
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
        //endregion
    }
}
