package com.xgq.dao;

import com.xgq.pojo.Brand;
import com.xgq.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:CategoryDao
 * Package: com.xgq.dao
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/1 15:15
 * @Version 1.0
 */
public interface CategoryDao {
    /**
     * 获取所有分类的列表
     * @return
     */
    List<Category> findAllCategory();

    /**
     * 获取分类对象根据传入的cate_id
     * @param cate_id
     * @return
     */
    Category findAllCategoryByCate_id(Integer cate_id);

    /**
     * 添加分类对象到数据库
     * @param category
     */
    void insertCategory(Category category);

    /**
     * 删除分类根据传入的id
     * @param cate_id
     */
    void deleteCategory(Integer cate_id);

    /**
     * 根据id获取分类对象
     * @param cate_id
     * @return
     */
    Category findCategoryByCate_id(Integer cate_id);
    /**
     * 查询分类对应品牌。多对多关系
     * @return
     */
    List<Brand> findIsCheckedBrandList();

    /**
     * 更新分类对象根据id
     * @param category
     */
    void updateCategoryByObject(Category category);

    /**
     * 删除品牌与分类的关系
     * @param cate_id
     */
    void deleteBrand_Category(Integer cate_id);
    /**
     * 重新插入品牌与分类的关系
     * @param brand_ids
     * @param cate_id
     */
    void insertBrand_Category(@Param("brand_ids") String[] brand_ids, @Param("cate_id") Integer cate_id);



}
