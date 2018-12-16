package com.mur.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/13 10:36
 **/
@RestController
@RequestMapping("demo")
public class Demo {

    @GetMapping("test")
    public String test() {
        return "success";
    }
}
