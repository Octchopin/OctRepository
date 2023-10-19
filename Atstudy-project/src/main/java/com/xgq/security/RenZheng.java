package com.xgq.security;




import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 认证：判断当前登录的用户的角色 是不是被授权的角色
 * AccessDecisionManager 请求认证管理器
 * @author xgq
 * @date 2023/7/16 下午 2:33
 */
@Component
public class  RenZheng implements AccessDecisionManager {


    //decide就是书写认证的过程

    /**
     *
     * @param authentication 认证 (可以通过authentication 判断用户是否登录)
     * @param o
     * @param collection 就是被授权的角色列表
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println("-----开始认证-----");

        //遍历，被授权的角色列表 collection

        for(ConfigAttribute attr:collection){
            //attr对象就是封装了 每个被授权的角色
            //grantName 就是被授权的角色的名字
            String grantName=attr.getAttribute();
            //判断当前用户是否登录认证成功（是否登录成功）
            if(authentication==null){
                System.out.println("****权限认证失败");
                throw new AccessDeniedException("权限认证失败！");
            }

            //如果 grantName是 ROLE_LOGIN 也就是默认的角色
            if("ROLE_LOGIN".equals(grantName)){
                //如果被授权的角色正好是默认角色
                //说明没有登录
                if(authentication instanceof AnonymousAuthenticationToken){
                    System.out.println("-----用户还没有登录");
                    throw new BadCredentialsException("请先登录！");
                }else{
                    System.out.println("可以访问公共资源");
                    return;
                }
            }

            //到这个位置，说明不是默认的授权
            //需要看看我们当前登录的用户的角色是否和授权的列表有一样的
            //roleList就是当前登录的用户的角色列表
            Collection<? extends GrantedAuthority> roleList=authentication.getAuthorities();

            //遍历当前用户的角色列表 role 就封装了当前用户的每个角色信息
            for(GrantedAuthority role:roleList){
                System.out.println("授权的角色："+grantName);
                System.out.println("当前用户的角色："+role.getAuthority());
                //授权的角色和认证的角色一致
                if(grantName.equals(role.getAuthority())){
                    System.out.println("权限认证通过");
                    return;
                }
            }
        }

        System.out.println("----权限认证失败");
        throw new AccessDeniedException("权限认证失败");

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}