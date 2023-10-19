package com.xgq.service.Imp;

import com.xgq.dao.AdminDao;
import com.xgq.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * ClassName:AdminLoginService
 * Package: com.xgq.service.Imp
 * Description:
 *针对登录操作做的
 * @Author XGQ
 * @Create 2023/7/22 15:31
 * @Version 1.0
 */
@Service
public class AdminLoginService implements UserDetailsService {
    @Autowired
    private AdminDao ad;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        //根据用户名查询用户对象
     Admin admin= ad.findAdminByUsername(s);
        if(admin==null){
            //没有查到用户，说明登录失败
            throw  new UsernameNotFoundException("用户名填写错误");
        }
        System.out.println("登录成功：用户登录的信息是："+admin);
        return admin;
    }
}
