package com.xgq.service.Imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgq.common.ComConfig;
import com.xgq.dao.RoleDao;
import com.xgq.pojo.Permission;
import com.xgq.pojo.Role;
import com.xgq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:RoleService
 * Package: com.xgq.service.Imp
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/25 0:31
 * @Version 1.0
 */
@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAllRoleList() {
        return roleDao.findAllRole();
    }

    @Override
    public PageInfo<Role> findAllRoleAdminList(Integer page) {
        //设置分页信息
        PageHelper.startPage(page, ComConfig.PAGE_SIZE);
        //获取分页的总数据对象
        List<Role> roleList=roleDao.findAllRole();

        //将数据对象放进分页对象中
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    @Override
    public List<Permission> findAllPermissionList() {
        return roleDao.findAllPermissionList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertRole(Role role, Integer[] permission_ids) {
        //插入角色简单类型的字段
        roleDao.insertRole(role);
     //添加角色对应的权限信息
        if (permission_ids != null&& permission_ids.length>0) {
        roleDao.insertRolePermission(permission_ids,role.getRole_id());
        }
    }

    @Override
    public void deletePermissionRole(Integer role_id) throws Exception{
        //删除角色和权限关联
        roleDao.deleteRolePermission(role_id);
        //删除角色
        roleDao.deleteRoleByRole_id(role_id);
    }

    @Override
    public Role findRoleById(Integer role_id) {
        return roleDao.findRoleById(role_id);
    }

    @Override
    public void updateRole(Role role, Integer [] permission_ids) {
        //更新角色列表
        roleDao.updateRole(role);

        if (permission_ids != null&&permission_ids.length>0) {

            //1更新权限之前把修改前角色权限关联全部删除
            roleDao.deleteRolePermission(role.getRole_id());

            //2将新的角色权限关系插入
            roleDao.insertRolePermission(permission_ids, role.getRole_id());
        }


    }
}
