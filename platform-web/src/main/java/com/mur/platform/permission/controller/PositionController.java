package com.mur.platform.permission.controller;

import com.mur.domain.web.Result;
import com.mur.platform.permission.domain.Position;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.mur.platform.permission.service.PositionService;

/**
 * 岗位 前端控制器
 *
 * @author Mu.R
 * @since 2018-12-17
 */
@RestController
@RequestMapping("/permission/position")
public class PositionController {
  @Autowired private PositionService positionService;

  @PostMapping("/")
  public Result save(@RequestBody Position position) {
    positionService.save(position, "");
    return Result.ok();
  }
}
