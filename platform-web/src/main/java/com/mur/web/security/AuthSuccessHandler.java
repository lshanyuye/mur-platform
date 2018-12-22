package com.mur.web.security;

import com.mur.domain.web.UserProfile;
import com.mur.platform.permission.service.ProfileService;
import com.mur.web.constants.WebConstants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/** @ClassName AuthSuccessHandler @Description TODO @Author Administrator @Date 2018/12/15 15:46 */
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  private static Logger logger = LoggerFactory.getLogger(AuthSuccessHandler.class);

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {
    String ip = getIpAddr(request);
    String equipment = request.getHeader("User-Agent");
    logger.info("login by " + ip + " for " + equipment);
    WebApplicationContext cxt =
        WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
    UserDetails userDetails =
        (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    ProfileService profileService = (ProfileService) cxt.getBean("profileService");
    UserProfile userProfile = profileService.buildUserProfileByUsername(userDetails.getUsername());
    HttpSession session = request.getSession();
    session.setAttribute(WebConstants.CURRENT_USER, userProfile);
    //        UserProfile userProfile = profileService.buildUserProfileByUsername()
    response.setStatus(HttpServletResponse.SC_OK);
  }

  /**
   * 获取IP
   *
   * @param request
   * @return
   */
  private String getIpAddr(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }
}
