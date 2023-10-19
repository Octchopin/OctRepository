package com.xgq.security;

/**
 * ClassName:PermissionErrorHandle
 * Package: com.xgq.security
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/23 17:59
 * @Version 1.0
 */

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限认证失败管理器
 * */
@Component
public class PermissionErrorHandle implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        // 权限认证失败  重定向 到 权限错误提示页面
        response.sendRedirect("/common/permissionerror");
    }
}