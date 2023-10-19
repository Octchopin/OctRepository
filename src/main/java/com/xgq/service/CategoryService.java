package com.xgq.service;

import com.xgq.pojo.Brand;
import com.xgq.pojo.Category;

import java.util.List;

/**
 * ClassName:CategoryService
 * Package: com.xgq.service
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/1 15:14
 * @Version 1.0
 */
public interface CategoryService {




    /**
     * 获取所有分类列表
     * @return
     */
    List<Category> findCategory();

    /**
     * 根据id获取分类对象
     * @param cate_id
     * @return
     */
    Category findCategoryByCate_id(Integer cate_id);

    /**
     * 添加分类的内容到数据库
     * @param category
     */
    void saveCategory(Category category) ;

    /**
     * 删除分类，报异常处理跳转声明
     * @param cate_id
     */
    void deleteCategory(Integer cate_id)throws Exception;

    /**
     * 根据id获取分类对象
     * @param cate_id
     * @return
     */
    Category findCategoryByCateid(Integer cate_id);

    /**
     * 更新分类对象，同时更新分类与品牌的关系
     * @param brand_ids
     * @param category
     */
    void updateCategory(String [] brand_ids, Category category) throws Exception;
}
