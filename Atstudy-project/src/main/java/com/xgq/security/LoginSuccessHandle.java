package com.xgq.security;

/**
 * ClassName:LoginSuccessHandle
 * Package: com.xgq.security
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/23 17:58
 * @Version 1.0
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录验证成功处理器
 * */
public class LoginSuccessHandle implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException,ServletException {
        // 登录成功 重定向到首页
        response.sendRedirect("/");
    }
}