package com.xgq.service.Imp;

import com.xgq.dao.CategoryDao;
import com.xgq.pojo.Brand;
import com.xgq.pojo.Category;
import com.xgq.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.CSS;
import java.util.List;

/**
 * ClassName:CategoryServiceImp
 * Package: com.xgq.service.Imp
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/1 15:15
 * @Version 1.0
 */
@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findCategory() {
        return categoryDao.findAllCategory();
    }

    @Override
    public Category findCategoryByCate_id(Integer cate_id) {
        return categoryDao.findAllCategoryByCate_id(cate_id);
    }

    @Override
    public void saveCategory(Category category) {

        categoryDao.insertCategory(category);
    }

    @Override
    public void deleteCategory(Integer cate_id) throws Exception {


        //删除对应的数据库内的分类根据传入的id
        categoryDao.deleteCategory(cate_id);


    }

    @Override
    public Category findCategoryByCateid(Integer cate_id) {
        return categoryDao.findCategoryByCate_id(cate_id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCategory(String [] brand_ids, Category category) throws Exception{
        //先更新分类对象
        categoryDao.updateCategoryByObject(category);

        //在更新分类与品牌的关系列表
        if (brand_ids.length>0&& brand_ids!=null) {
            //先删除原有品牌与分类关系，根据id
            categoryDao.deleteBrand_Category(category.getCate_id());

            //在插入新的品牌与分类对象的关系
            categoryDao.insertBrand_Category(brand_ids,category.getCate_id());
        }
    }
}
