package com.xgq.service;


import com.xgq.pojo.Menu;

import java.util.List;

/**
 * ClassName:MenuService
 * Package: com.xgq.service
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/24 21:54
 * @Version 1.0
 */
public interface MenuService {

    List<Menu> findMenuListByUsername(String admin_name);
}
