package com.xgq.service;

import com.github.pagehelper.PageInfo;
import com.xgq.pojo.Admin;

/**
 * ClassName:AdminService
 * Package: com.xgq.service
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/24 21:53
 * @Version 1.0
 */
public interface AdminService {
    
    /**
     * 获取所有的员工且分页
     * @param page
     * @return
     */
    PageInfo<Admin> findAllAdmin(Integer page);

    void addAdmin(Admin admin, Integer[] role_ids);

    /**
     * 删除一个员工,先删除关联关系角色与员工的关联关系
     * @param admin_id
     */
    void deleteAdmin(Integer admin_id);

    /**
     * 根据用户id获取用户
     * @param admin_id
     * @return
     */
    Admin findAdminByAdmin_id(Integer admin_id);

    /**
     *
     * @param admin
     * @param role_ids
     */
    void updateAdmin(Admin admin, Integer[] role_ids);
}
