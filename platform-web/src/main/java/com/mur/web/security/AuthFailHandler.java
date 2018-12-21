package com.mur.web.security;

import com.alibaba.fastjson.JSON;
import com.mur.exception.BusinessException;
import com.mur.exception.ExceptionCode;
import com.mur.exception.ExceptionDetail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/** @ClassName AuthFailHandler @Description TODO @Author Administrator @Date 2018/12/15 15:47 */
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler {

  private static Logger logger = LoggerFactory.getLogger(AuthFailHandler.class);

  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
      throws IOException, ServletException {
    logger.info("login fail");

    String message = "";
    if (exception instanceof LockedException) {
      message = "帐号已被锁定，请联系管理员";
    } else if (exception instanceof DisabledException) {
      message = "帐号已失效，请联系管理员";
    } else if (exception instanceof AccountExpiredException) {
      message = "帐号已过期，请联系管理员";
    } else if (exception instanceof BadCredentialsException) {
      message = "帐号密码不正确";
    } else if (exception instanceof UsernameNotFoundException) {
      message = "帐号不存在";
    }
    BusinessException businessException = new BusinessException(message);
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    response.setContentType("application/json;charset=utf-8");
    PrintWriter out = response.getWriter();
    ExceptionDetail exceptionDetail =
        ExceptionDetail.constructExceptionDetail(
            ExceptionCode.BUSINESS_EXCEPTION, request.getRequestURI(), businessException);
    out.write(JSON.toJSONString(exceptionDetail));
    out.flush();
    out.close();

    //    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, message);
  }
}
