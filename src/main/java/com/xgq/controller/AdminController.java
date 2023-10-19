package com.xgq.controller;

import com.github.pagehelper.PageInfo;
import com.xgq.pojo.Admin;
import com.xgq.pojo.Role;
import com.xgq.service.AdminService;

import com.xgq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName:AdminController
 * Package: com.xgq.controller
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/21 22:20
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    /**
     * 跳转登录的客户端页面
     */
    @RequestMapping("/login")
    public void login(){

    }

    /**
     * 执行登录操作
     * @param username
     * @param password
     */
    @RequestMapping("/dologin")
    public void dologin(String username,String password){}

    /**
     * 显示admin页面
     * @param model
     * @param page
     */
    @RequestMapping("/admin")
    public void admin(Model model,Integer page){
        if (page == null) {
            page=1;
        }
        PageInfo<Admin> pager=adminService.findAllAdmin(page);
        model.addAttribute("pager",pager);
    }

    /**
     * 显示添加员工
     */
    @RequestMapping("/add")
    public  void  add(Model model){
        //获取所有的角色列表
        List<Role> roleList=roleService.findAllRoleList();
        model.addAttribute("roleList",roleList);
    }
    /**
     * save保存insert员工
     * @param admin
     * @param role_ids
     */
    @RequestMapping("/save")
    public  String save(Admin admin,Integer [] role_ids){

           adminService.addAdmin(admin,role_ids);
           return "/common/ok";

    }

    /**
     * 删除员工
     * @param admin_id
     * @return
     */
   @RequestMapping("/delete")
    public String delete(Integer admin_id){
       adminService.deleteAdmin(admin_id);
        return "/common/ok";
    }

    /**
     * restful风格获取用户信息，且完成修改，返回值不能用void
     * @param admin_id
     */
    @RequestMapping("/update/{admin_id}")
    public String update(@PathVariable("admin_id")Integer admin_id, Model model){
      Admin admin= adminService.findAdminByAdmin_id(admin_id);

      model.addAttribute("admin",admin);
      return "/admin/update";
    }

    /**
     * 更新用户信息，及用户角色关联表的信息
     * @param admin
     * @param role_ids
     * @return
     */
    @RequestMapping("/alter")
    public String alter(Admin admin,Integer [] role_ids){

        //更改用户表的用户信息,更改用户角色关联表的信息根据关联ids

        adminService.updateAdmin(admin,role_ids);
        return "/common/ok";
    }
}
