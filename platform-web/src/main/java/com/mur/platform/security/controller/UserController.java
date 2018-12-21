package com.mur.platform.security.controller;


import com.mur.domain.web.Result;
import com.mur.domain.web.UserProfile;
import com.mur.platform.security.domain.User;
import com.mur.web.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.mur.platform.security.service.UserService;

/**
 * <p>
 * 用于系统登录 前端控制器
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-15
 */
@RestController
@RequestMapping("/security/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Result save(@RequestBody User user) {
        userService.save(user, "");
        return Result.ok("保存成功");
    }
}

