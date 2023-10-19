package com.xgq.security;

/**
 * ClassName:SecurityConfig
 * Package: com.xgq.security
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/23 18:13
 * @Version 1.0
 */

import com.xgq.service.Imp.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * SpringSecurity 的核心配置文件 配置登录页面 以及 各种跳转
 */
@Configuration
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Security 用户 业务层 对象
    @Autowired
    private AdminLoginService adminService;

    // 授权对象
    @Autowired
    private ShouQuan permissionInterceptor;

    // 认证对象
    @Autowired
    private RenZheng validPermission;

    // 权限认证失败处理器
    @Autowired
    private PermissionErrorHandle permissionErrorHandle;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 配置 用户登录的验证方式
        auth.userDetailsService( adminService ) // 根据用户填写的账户名称获取用户对象
                .passwordEncoder( new BCryptPasswordEncoder()); // 将获取的用户对象的密码和用户填写的密码加密后进行等性判断
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 配置 Security 过滤请求的 例外
        web.ignoring().antMatchers("/admin/login","/common/**","/resources/images/**","/resources/css/**","/resources/scripts/**","/favicon.ico","/assets/**")
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/images/**", "/webjars/**", "/v2/api-docs", "/configuration/ui", "/configuration/security");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置 SpringSecurity 流程
        http.authorizeRequests()   // 配置 请求需要进行权限认证
                //withObjectPostProcessor设置请求处理器的方法
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(permissionInterceptor);   // 配置授权对象
                        o.setAccessDecisionManager(validPermission);    // 配置认证对象
                        return o;
                    }
                })
                .and()
                .formLogin()    // 开启 表单登录验证
                .loginPage("/admin/login")  // 设置登录表单页面的方法
                .loginProcessingUrl("/admin/dologin")   // 指定 验证登录表单的url路径
                .usernameParameter("username")  // 账户名称的形参名称2
                .passwordParameter("password")  // 账户密码的形参名称
                .failureHandler( new LoginErrorHandle())    // 设置登录认证失败处理器的方法
                .successHandler( new LoginSuccessHandle())  //设置登录认证成功处理器的方法
                .permitAll()
                .and()
                .logout()   // 开启 安全退出验证
                .logoutUrl("/admin/logout") // 设置安全退出URL的方法
                .logoutSuccessHandler(new LogoutSuccessHandle())    // 安全退出成功处理器
                .permitAll()
                .and()
                .csrf()      // 跨域请求配置
                .disable()  // 禁用
                .exceptionHandling()
                .accessDeniedHandler(permissionErrorHandle); // 设置权限认证失败处理器的方法
    }
}