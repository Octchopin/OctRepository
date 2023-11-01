package com.xgq.controller;

import com.xgq.pojo.Menu;
import com.xgq.service.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:IndexController
 * Package: com.xgq.controller
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/23 18:17
 * @Version 1.0
 */
@Controller
@RequestMapping(value = {"/", "/index"})
public class IndexController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = {"/index","/"})
    public String index(Authentication authentication, HttpSession session) {
        String admin_name = authentication.getName();
        session.setAttribute("loginname",admin_name);

        //根据用户名获取菜单信息
  List<Menu> menuList= menuService.findMenuListByUsername(admin_name);
  session.setAttribute("menuList",menuList);
        return "/index/index";
    }
}
