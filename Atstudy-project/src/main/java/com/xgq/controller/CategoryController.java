package com.xgq.controller;

import com.xgq.pojo.Brand;
import com.xgq.pojo.Category;
import com.xgq.service.BrandService;
import com.xgq.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ClassName:CategoryController
 * Package: com.xgq.controller
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/1 15:12
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/admin")
    public void admin(Model model){
      //获取所有的分类列表
      List<Category> categoryList= categoryService.findCategory();

        model.addAttribute("categoryList",categoryList);

    }
    @RequestMapping("/add")
    public void add(Integer cate_id,Model model){
        //获取某一个分类对象
        Category category= categoryService.findCategoryByCate_id(cate_id);

        model.addAttribute("category",category);

    }
    @RequestMapping("/save")
    public String save(Category category){

          //更新数据
        categoryService.saveCategory(category);

       return "/common/ok";

    }
    @RequestMapping("/delete")
    public String delete(Integer cate_id,Model model){

        //删除数据
        try {
            categoryService.deleteCategory(cate_id);
        } catch (Exception e) {
            model.addAttribute("msg","删除失败，对不起，分类还与品牌商品等有关联，请检查");
            return "/common/nok";
        }

        return "/common/ok";

    }
    @RequestMapping("/update")
    public void update(Integer cate_id,Model model){
      //获取分类对象及其分类对象下的品牌列表，一个分类对应多个品牌
        Category category=categoryService.findCategoryByCateid(cate_id);
        model.addAttribute("category",category);


    }
    @RequestMapping("/alter")
    public String alter(String [] brand_ids,Category category,Model model){
       try {
           //执行更新分类对象
           categoryService.updateCategory(brand_ids,category);


       }catch (Exception e){
           model.addAttribute("msg","所选的品牌管理不能为空,故修改失败!!");
           return "/common/nok";
       }

           return "/common/ok";
    }
}
