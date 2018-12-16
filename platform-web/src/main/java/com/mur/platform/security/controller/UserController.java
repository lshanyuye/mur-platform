package com.mur.platform.security.controller;


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
public class UserController {
  @Autowired
  private UserService userService;
}
