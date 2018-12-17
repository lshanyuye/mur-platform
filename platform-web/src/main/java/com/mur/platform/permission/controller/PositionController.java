package com.mur.platform.permission.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.mur.platform.permission.service.PositionService;

/**
 * <p>
 * 岗位 前端控制器
 * </p>
 *
 * @author Mu.R
 * @since 2018-12-17
 */
@RestController
@RequestMapping("/permission/position")
public class PositionController {
  @Autowired
  private PositionService positionService;
}

