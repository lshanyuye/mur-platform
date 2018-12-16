package com.mur.web.security;

import com.mur.exception.BusinessException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * @ClassName AuthFailHandler
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/15 15:47
 **/
public class AuthFailHandler extends SimpleUrlAuthenticationFailureHandler{

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("{\"status\":\"error\",\"msg\":\"");
        sb.append("未登陆!");
        sb.append("\"}");
        out.write(sb.toString());
        out.flush();
        out.close();
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication failed");
    }
}
