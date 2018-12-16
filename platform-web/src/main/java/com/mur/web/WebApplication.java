package com.mur.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName WebApplication
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/13 10:32
 **/
@SpringBootApplication
@EnableConfigurationProperties
@MapperScan(basePackages = {"com.mur.platform.**.mapper"})
@ComponentScan(basePackages = {"com.mur.platform", "com.mur.web"})
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
