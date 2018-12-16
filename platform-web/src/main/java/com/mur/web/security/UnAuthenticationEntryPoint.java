package com.mur.web.security;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @ClassName LoginUrlAuthenticationEntryPoint
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/15 15:29
 **/
public class UnAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)
            throws IOException, ServletException {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }
}
