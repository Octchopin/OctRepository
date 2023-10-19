package com.xgq.controller;

import com.github.pagehelper.PageInfo;
import com.xgq.pojo.Permission;
import com.xgq.pojo.Role;
import com.xgq.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ClassName:RoleController
 * Package: com.xgq.controller
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/29 21:07
 * @Version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/admin")
    public void admin(Integer page, Model model) {
        if (page == null) {
            page = 1;
        }

        //调用service，通过Service获取角色即角色获取的权限
        PageInfo<Role> pageInfo = roleService.findAllRoleAdminList(page);

        model.addAttribute("pager", pageInfo);

    }

    @RequestMapping("/add")
    public void add(Model model) {

        List<Permission> permissionList = roleService.findAllPermissionList();

        model.addAttribute("permissionList", permissionList);
    }

    @RequestMapping("/save")
    public String save(Role role, Integer[] permission_ids) {
        //插入role简单类型的字段和添加角色对应的权限信息
        roleService.insertRole(role, permission_ids);

        return "/common/ok";

    }

    @RequestMapping("/delete")
    @Transactional(rollbackFor = Exception.class)
    public String delete(Integer role_id, Model model) {
        //删除角色和权限关联
        try {
            roleService.deletePermissionRole(role_id);
        } catch (Exception e) {

            model.addAttribute("msg", "对不起！，你还有用户与该角色关联，删除失败！！");
            return "/common/nok";
        }


        return "/common/ok";

    }

    @RequestMapping("/update/{role_id}")
    public String update(@PathVariable("role_id") Integer role_id, Model Model) {

        //根据角色id查询对应的角色
        Role role = roleService.findRoleById(role_id);
        Model.addAttribute("role", role);
        return "/role/update";
    }

    @RequestMapping("/alter")
    @Transactional(rollbackFor = Exception.class)
    public String alter(Role role, Integer [] permission_ids) {

        //将传入角色信息更新数据库
           roleService.updateRole(role,permission_ids);

           return  "/common/ok";
    }


}
