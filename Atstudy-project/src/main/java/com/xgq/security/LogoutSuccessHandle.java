package com.xgq.security;

/**
 * ClassName:LogoutSuccessHandle
 * Package: com.xgq.security
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/23 18:16
 * @Version 1.0
 */

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 安全退出成功处理器
 * */
public class LogoutSuccessHandle implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 安全退出 重定向到 登录表单页面
        response.sendRedirect("/admin/login");
    }
}