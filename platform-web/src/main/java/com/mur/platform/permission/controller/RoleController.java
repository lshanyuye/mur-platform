package com.mur.platform.permission.controller;

import com.mur.domain.web.Result;
import com.mur.platform.permission.domain.Role;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.mur.platform.permission.service.RoleService;

/**
 * 角色 前端控制器
 *
 * @author Mu.R
 * @since 2018-12-17
 */
@RestController
@RequestMapping("/permission/role")
public class RoleController {
  @Autowired private RoleService roleService;

  @PostMapping("/")
  public Result save(@RequestBody Role role) {
    roleService.save(role, "");
    return Result.ok();
  }
}
