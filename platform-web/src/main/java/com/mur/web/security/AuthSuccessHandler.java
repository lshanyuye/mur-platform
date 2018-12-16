package com.mur.web.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 * @ClassName AuthSuccessHandler
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/15 15:46
 **/
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
