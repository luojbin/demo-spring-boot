package com.luojbin.demo.spring.boot.parent;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.luojbin.demo.spring.boot.parent.dao")
public class Application {

    /**
     * springBoot 建议将 main 方法放在项目根包下
     * 因为许多与包有关的注解, 默认包名都是当前类所在的包, 如组件扫描等
     * 将 main 方法放置在根包之下, 则在其上添加的注解都能正确获取到需要的包名
     */
    public static void main(String[] args) {
        // Map<String, Object> defaultMap = new HashMap<>();
        // defaultMap.put("server.port", "8103");
        // 直接使用 SpringApplication 提供的 run 方法, 执行当前配置类
        SpringApplication.run(Application.class, args);

        // 构造当前应用的实例
        // SpringApplication application = new SpringApplication(Application.class);
        // application.setDefaultProperties(defaultMap);
        // application.setBannerMode(Banner.Mode.OFF);
        // application.run();

        // 通过 builder 构造当前应用对象
        // new SpringApplicationBuilder()
        //         .bannerMode(Banner.Mode.OFF)
        //         .sources(Application.class)
        //         .run(args);
    }
}
