package com.xgq.service;

import com.github.pagehelper.PageInfo;
import com.xgq.pojo.Permission;
import com.xgq.pojo.Role;

import java.util.List;

/**
 * ClassName:RoleService
 * Package: com.xgq.service
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/25 0:30
 * @Version 1.0
 */

public interface RoleService {
    /**
     * 获取所有的角色列表
     * @return
     */
    List<Role> findAllRoleList();

    /**
     *
     * 获取所有的角色分页
     * @param page
     * @return
     */
    PageInfo<Role> findAllRoleAdminList(Integer page);

    /**
     * 获取所有的权限列表
     * @return
     */
    List<Permission> findAllPermissionList();

    /**
     *插入角色简单类型的字段和添加角色对应的权限信息
     * @param role
     * @param permission_ids
     */
    void insertRole(Role role, Integer[] permission_ids);

    /**
     * 删除角色与权限关联及删除角色
     * @param role_id
     */
    void deletePermissionRole(Integer role_id) throws Exception;

    /**
     * 根据角色id查询对应的角色信息
     * @param role_id
     * @return
     */
    Role findRoleById(Integer role_id);

    /**
     * 更新角色列表及权限角色列表
     * @param role
     * @param permission_ids
     */
    void updateRole(Role role, Integer [] permission_ids);


}
