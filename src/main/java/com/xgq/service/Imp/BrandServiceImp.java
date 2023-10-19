package com.xgq.service.Imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgq.common.ComConfig;
import com.xgq.dao.BrandDao;
import com.xgq.pojo.Brand;
import com.xgq.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * ClassName:BrandServiceImp
 * Package: com.xgq.service.Imp
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/30 23:49
 * @Version 1.0
 */
@Service
public class BrandServiceImp implements BrandService {

    @Autowired
    private BrandDao brandDao;

    @Override
    public PageInfo<Brand> findBrand(Integer page) {

        PageHelper.startPage(page, ComConfig.PAGE_SIZE);
        //获取品牌列表
        List<Brand> brandList = brandDao.findBrand();
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return pageInfo;
    }

    @Override
    public void savaBrand(Brand brand) {
        String brand_id = String.valueOf(new Date().getTime());
        brand.setBrand_id(brand_id);
        brandDao.savaBrand(brand);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String brand_id) {
        //先删除品牌关系
        brandDao.deleteBrandCategory(brand_id);

        //再删除品牌
        brandDao.deleteBrand(brand_id);
    }

    @Override
    public Brand findOneBrand(String brand_id) {
        return brandDao.findOneBrand(brand_id);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandDao.updateOneBrand(brand);
    }

    @Override
    public void deleteBrandCategories(Integer[] cate_ids, Brand brand) {
        //更新品牌信息
        brandDao.updateOneBrand(brand);
        //更新品牌分类关系表

        if (cate_ids != null&&cate_ids.length>0) {
            //删除原先的品牌分类关系表
            brandDao.deleteBrandCategory(brand.getBrand_id());
            //插入新的品牌关系表
            brandDao.insertBrandCategory(brand.getBrand_id(),cate_ids);
        }

    }

    @Override
    public List<Brand> findBrandList() {
        return brandDao.findBrand();
    }
}
