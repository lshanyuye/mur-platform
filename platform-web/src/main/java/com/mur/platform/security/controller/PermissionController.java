package com.mur.platform.security.controller;

import com.mur.domain.web.Result;
import com.mur.domain.web.UserProfile;
import com.mur.platform.security.service.ProfileService;
import com.mur.web.constants.WebConstants;
import com.mur.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName PermissionController @Description TODO @Author Administrator @Date 2018/12/21 17:17
 */
@Controller
public class PermissionController extends BaseController {
  @Autowired private ProfileService profileService;
  @GetMapping("/loginPage")
  public String login() {
    return "/page/login";
  }

    /**
     * 获取用户信息
     * @return
     */
  @GetMapping("user-profile")
  public Result userProfile() {
    UserProfile userProfile = getUserProfile();
    userProfile = profileService.buildUserProfileByUsername(userProfile.getUsername());
    httpSession.setAttribute(WebConstants.CURRENT_USER, userProfile);
    return Result.ok(userProfile);
  }
}
