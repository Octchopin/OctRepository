package com.xgq.dao;

import com.xgq.pojo.Menu;

import java.util.List;

/**
 * ClassName:MenuDao
 * Package: com.xgq.dao
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/24 21:51
 * @Version 1.0
 */
public interface MenuDao {
    List<Menu> findMenuListByUsename(String admin_name);
}
