package com.xgq.service.Imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgq.common.ComConfig;
import com.xgq.dao.AdminDao;
import com.xgq.pojo.Admin;
import com.xgq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ClassName:AdminServiceImp
 * Package: com.xgq.service.Imp
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/24 21:54
 * @Version 1.0
 */
@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public PageInfo<Admin> findAllAdmin(Integer page) {
        PageHelper.startPage(page, ComConfig.PAGE_SIZE);
        List<Admin> adminList =adminDao.findAllAdmin();
        PageInfo<Admin> pageInfo=new PageInfo<>(adminList);
        return pageInfo;
    }

    @Override
    //事务回滚
    @Transactional(rollbackFor =Exception.class )
    public void addAdmin(Admin admin, Integer[] role_ids) {
       //对传入过来的员工密码进行加密
       admin.setAdmin_pass(new BCryptPasswordEncoder().encode(admin.getAdmin_pass()));
        adminDao.addAdmin(admin);

        //如果roleid不为空，则添加角色和用户关联
        if (role_ids != null&&role_ids.length>0) {
            adminDao.insertAdminRole(admin.getAdmin_id(),role_ids);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAdmin(Integer admin_id) {
        //删除关联关系
        adminDao.deleteAdmin_RoleByAdmin_id(admin_id);
        //再删除用户信息
        adminDao.deleteAdmin(admin_id);
    }

    @Override
    public Admin findAdminByAdmin_id(Integer admin_id) {
        return adminDao.findAdminByAdmin_id(admin_id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAdmin(Admin admin, Integer[] role_ids) {
        if (admin.getAdmin_pass()!= null && !admin.getAdmin_pass().trim().isEmpty()) {
            //对传入过来的员工密码进行加密
            admin.setAdmin_pass(new BCryptPasswordEncoder().encode(admin.getAdmin_pass()));
            adminDao.updateAdmin(admin);
        }


        //如果roleid不为空，则更新角色和用户关联
        if (role_ids != null&&role_ids.length>0) {
            //先清空原有的角色用户关联
            adminDao.deleteAdmin_roleByAdmin_id(admin.getAdmin_id());
            //再添加新的用户角色关联
            adminDao.updateAdminRole(admin.getAdmin_id(),role_ids);
        }
    }

}
