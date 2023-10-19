package com.xgq.dao;

import com.xgq.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:AdminDao
 * Package: com.xgq.dao
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/22 15:31
 * @Version 1.0
 */
public interface AdminDao {
    /**
     * 根据用户名查询用户对象
     * @param s
     * @return
     */
    Admin findAdminByUsername(String s);

    List<Admin> findAllAdmin();

    void addAdmin(Admin admin);

    /**
     * 插入员工与角色的关联
     * @param admin_id
     * @param role_ids
     */

    void insertAdminRole(@Param("admin_id") Integer admin_id,@Param("role_ids") Integer[] role_ids);

    /**
     * 删除用户和角色的关联关系表的信息
     * @param admin_id
     */
    void deleteAdmin_RoleByAdmin_id(Integer admin_id);

    /**
     * 删除员工
     * @param admin_id
     */
    void deleteAdmin(Integer admin_id);

    /**
     * 根据用户id获取用户信息
     * @param admin_id
     * @return
     */
    Admin findAdminByAdmin_id(Integer admin_id);

    /**
     * 更新用户信息表
     * @param admin
     */
    void updateAdmin(Admin admin);

    /**
     * 更新用户角色关联表
     * @param admin_id
     * @param role_ids
     */

    void updateAdminRole(@Param("admin_id") Integer admin_id,@Param("role_ids") Integer[] role_ids);


    void deleteAdmin_roleByAdmin_id(Integer admin_id);
}
