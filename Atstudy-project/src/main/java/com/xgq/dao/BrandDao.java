package com.xgq.dao;

import com.xgq.pojo.Brand;
import com.xgq.pojo.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:BrandDao
 * Package: com.xgq.dao
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/30 23:55
 * @Version 1.0
 */
public interface BrandDao {
    /**
     * 获取当前所有品牌列表内容
     * @return
     */
    List<Brand> findBrand();

    /**
     * 插入品牌
     * @param brand
     */
    void savaBrand(Brand brand);

    /**
     * 根据传入的id删除对应的品牌分类关系
     * @param brand_id
     */
    void deleteBrandCategory(String brand_id);

    /**
     * 删除品牌
     * @param brand_id
     */
    void deleteBrand(String brand_id);

    /**
     * 根据传入的品牌id找到品牌信息于数据库
     * @param brand_id
     * @return
     */
    Brand findOneBrand(String brand_id);

    /**
     * 根据一个品牌对应多个分类，找到对应的分类列表
     * @param brand_id
     * @return
     */
    List<Category> findCategoryList(String brand_id);

    /**
     * 更新品牌操作
     * @param brand
     */
    void updateOneBrand(Brand brand);

    /**
     * 插入新的分类品牌关联表
     * @param brand_id
     * @param cate_ids
     */
    void insertBrandCategory(@Param("brand_id") String brand_id,@Param("cate_ids") Integer[] cate_ids);
}
