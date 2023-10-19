package com.xgq.pojo;

import org.springframework.security.core.GrantedAuthority;


import java.util.List;

/**
 * ClassName:Role
 * Package: com.xgq.pojo
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/21 22:27
 * @Version 1.0
 */
public class Role implements GrantedAuthority {
    private Integer role_id;
    private String role_name;
    private Integer ischecked;
    //一个角色有多个权限列表好比一个用户有多个角色
    private  List<Permission> permissionList;

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public Integer getIschecked() {
        return ischecked;
    }

    public void setIschecked(Integer ischecked) {
        this.ischecked = ischecked;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }


    @Override
    public String getAuthority() {
        return this.role_name;
    }
}
