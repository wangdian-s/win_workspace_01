package com.wangdian.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
@SpringBootApplication:标注在某个类上，说明这个类是SpringBoot的主配置类，SpringBoot运行这个
类的main方法来启动SpringBoot应用；
将主配置类（@SpringBootApplication标注的类）的所在包及下面所有子包里面的所有组件扫描到
Spring容器；
@EnableAutoConfiguration：开启自动配置功能；
@AutoConfigurationPackage：自动配置包
@Import(AutoConfigurationPackages.Registrar.class)：给容器中导入组件；
*/
/*
* @RestController:
意味着这个Controller的所有方法上面都加了@ResponseBody(将Controller层的返回对象转换成指定格式后，
写入到response对象的body区，通常用来返回JSON数据或者是XML)
*/
@SpringBootApplication
@RestController//所有方法都返回内容到前端页面输出
@EnableScheduling//开启定时任务注解
@MapperScan(basePackages = "com.wangdian.springboot.dao")//开启mapper扫描包
public class HelloSpringboot {

    @RequestMapping("/hello")
    public String hello() {
        //int x = 1 / 0;

       String name = null;
       name.toCharArray();
        return "hello spring boot !!!";
    }

    public static void main(String[] args) {
        // 启动第一个springboot应用
        SpringApplication.run(HelloSpringboot.class, args);
    }
}