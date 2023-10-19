package com.xgq.service.Imp;

import com.xgq.dao.MenuDao;
import com.xgq.pojo.Menu;
import com.xgq.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:MenuServiceImp
 * Package: com.xgq.service.Imp
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/24 21:54
 * @Version 1.0
 */
@Service
public class MenuServiceImp implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> findMenuListByUsername(String admin_name) {
        return menuDao.findMenuListByUsename(admin_name);
    }
}
