package com.xgq.dao;

import com.xgq.pojo.Permission;
import com.xgq.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:RoleDao
 * Package: com.xgq.dao
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/22 22:40
 * @Version 1.0
 */
public interface RoleDao {
    List<Role> findRoleListByAdminId(@Param("admin_id") Integer admin_id);


    /**
     * 根据操作的url获取指定的角色列表
     *
     * @param reqUrl
     * @return
     */

    List<Role> getRoleListByOperateUrl(String reqUrl);

    List<Role> findAllRole();

    /**
     * 根据用户的id获取用户选择的角色
     *
     * @param admin_id
     * @return
     */
    List<Role> findCheckedRoleListByAdminId(@Param("admin_id") Integer admin_id);

    /**
     * 获取当前角色的权限列表
     *
     * @param role_id
     * @return
     */

    List<Permission> findRolePermissionList(@Param("role_id") Integer role_id);

    /**
     * 获取所有的权限列表
     *
     * @return
     */
    List<Permission> findAllPermissionList();

    /**
     * 插入角色简单类型的字段
     *
     * @param role
     */
    void insertRole(Role role);

    /**
     * 添加角色对应的权限信息
     *
     * @param permission_ids
     * @param role_id
     */
    void insertRolePermission(@Param("permission_ids") Integer[] permission_ids, @Param("role_id") Integer role_id);

    /**
     * 删除角色与权限关联
     *
     * @param role_id
     */
    void deleteRolePermission(Integer role_id);

    /**
     * 删除角色根据角色id
     *
     * @param role_id
     */
    void deleteRoleByRole_id(Integer role_id);

    /**
     * 根据角色id查询对应的角色信息
     *
     * @param role_id
     * @return
     */
    Role findRoleById(Integer role_id);

    /**
     * 获取已选中角色对应的权限列表
     *
     * @param role_id
     * @return
     */
    List<Permission> findIsCheckedRolePermissionList(Integer role_id);

    /**
     * 更新数据角色列表传入的对应的角色
     * @param role
     */
    void updateRole(Role role);
}
