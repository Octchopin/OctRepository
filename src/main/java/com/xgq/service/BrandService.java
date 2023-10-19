package com.xgq.service;

import com.github.pagehelper.PageInfo;
import com.xgq.pojo.Brand;

import java.util.List;

/**
 * ClassName:BrandService
 * Package: com.xgq.service
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/30 23:49
 * @Version 1.0
 */
public interface BrandService {

    /**
     * 分页当前品牌列表
     * @param page
     * @return
     */
    PageInfo<Brand> findBrand(Integer page);

    /**
     * 插入品牌
     * @param brand
     */
    void savaBrand(Brand brand);

    /**
     * 删除品牌与分类的关联
     * 删除品牌列表的某一品牌根据传进的品牌id
     * @param brand_id
     */
    void delete(String brand_id);

    /**
     * 根据传入的品牌id获取品牌信息
     * @param brand_id
     * @return
     */
    Brand findOneBrand(String brand_id);

    /**
     * 更新品牌信息
     * @param brand
     */
    void updateBrand(Brand brand);

    /**
     * 更新品牌信息并更新品牌与分类关系
     * @param cate_ids
     * @param brand
     */
    void deleteBrandCategories(Integer[] cate_ids, Brand brand);

    /**
     * 获取品牌列表
     * @return
     */
    List<Brand> findBrandList();
}
