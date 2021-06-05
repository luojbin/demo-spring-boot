package com.luojbin.demo.spring.boot.dependencies;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot 项目的启动入口, 要求放在项目根包下
 * 注解 SpringBootApplication 相当于 @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan 的组合
 * 注解 EnableAutoConfiguration 根据项目中添加的 jar 包, 自动配置项目, 一个sb项目中只有一个类添加此注解
 * 若某些内容不想让 springBoot 自动配置, 可以添加 exclude 属性,
 * 如 @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
 *
 * @author luojbin
 * @version 1.0
 * @date 2018-12-10 15:35
 */
@SpringBootApplication
public class BootApplication2 {

    /**
     * springBoot 建议将 main 方法放在项目根包下
     * 因为许多与包有关的注解, 默认包名都是当前类所在的包, 如组件扫描等
     * 将 main 方法放置在根包之下, 则在其上添加的注解都能正确获取到需要的包名
     */
    public static void main(String[] args) {
        SpringApplication.run(BootApplication2.class, args);

    }
}
