package com.mur.platform.sequence.controller;


import com.mur.platform.sequence.domain.SerialNumberRule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.mur.platform.sequence.service.SerialNumberRuleService;

/**
 * <p> 序列号规则 前端控制器 </p>
 *
 * @author Mu.R
 * @since 2018-12-14
 */
@RestController
@RequestMapping("/sequence/serial-number-rule")
public class SerialNumberRuleController {

    @Autowired
    private SerialNumberRuleService serialNumberRuleService;

    @PostMapping("/")
    public String save(@RequestBody SerialNumberRule rule) {
        serialNumberRuleService.save(rule, "admin");
        return "SUCCESS";
    }

    @GetMapping("/test/{bizKey}")
    public String testSerialNumber(@PathVariable("bizKey")String bizKey){
        return serialNumberRuleService.generateSerialNum("TEST", bizKey);
    }
}

