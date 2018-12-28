package com.mur.web.controller;

import com.mur.domain.web.UserProfile;
import com.mur.web.constants.WebConstants;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Administrator
 * @className BaseController
 * @description TODO
 * @date 2018/12/20 15:00
 */
public class BaseController {

  @Autowired
  protected HttpSession httpSession;

  public UserProfile getUserProfile() {
    UserProfile userProfile = (UserProfile) httpSession.getAttribute(WebConstants.CURRENT_USER);
    return userProfile;
  }
}
