package com.xgq.security;

/**
 * ClassName:ShouQuan
 * Package: com.xgq.security
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/23 17:36
 * @Version 1.0
 */

import com.xgq.dao.RoleDao;
import com.xgq.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * 这是一个授权类，请求资源的授权
 * FilterInvocationSecurityMetadataSource  就是请求资源授权
 * @author xgq
 * @date 2023/7/16 下午 1:47
 */
@Component
public class ShouQuan implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private RoleDao rd;




    //每个客户端请求都会经过这儿 ，所有我们就是在当前的getAttributes中去实现授权
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //当成是请求对象
        FilterInvocation req=(FilterInvocation) o;
        //获取请求资源的路径 reqUrl
        String reqUrl=req.getRequestUrl();
        //调用dao层 根据请求的url获取这个url对应的有权限的角色列表
        List<Role> roleList=rd.getRoleListByOperateUrl(reqUrl);

        //判断当前的角色列表是不是空
        if(!roleList.isEmpty()&&roleList.size()>0){
            //给每个角色列表进行授权
            //grantArray授权的数组的长度
            String[] grantArray=new String[roleList.size()];
            System.out.println("-----------开始授权------------");
            //如果授权？循环能访问到这个url的roleList 进行循环 ，一个个取出 设置到数组中去
            for(int i=0;i<roleList.size();i++){
                //将一个个角色的值 取出来 设置到数组中去
                grantArray[i]=roleList.get(i).getRole_name();
            }
            System.out.println("-----------授权完毕");
            //将数组中的列表进行返回
            return SecurityConfig.createList(grantArray);
        }else{
            //为了任何角色都能访问的路径 为了登录成功以后 能访问到公共路径的
            //ROLE_LOGIN 是一个字符串，这个字符串随便定义
            return SecurityConfig.createList("ROLE_LOGIN");
        }

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}