package com.xgq.controller;

import com.github.pagehelper.PageInfo;
import com.xgq.pojo.Category;
import com.xgq.pojo.Spu_attr_key;
import com.xgq.service.AttrService;
import com.xgq.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:AttrController
 * Package: com.xgq.controller
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/2 13:56
 * @Version 1.0
 */
@Controller
@RequestMapping("/attr")
public class AttrController {

    @Autowired
    private AttrService attrService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/admin")
    public String admin(Integer page, Model model) {
        if (page == null) {
            page = 1;
        }
        // 获取筛选属性键分页列表
        PageInfo<Spu_attr_key> pageInfo = attrService.findSpuAttrKeyPageList(page);

        model.addAttribute("pager", pageInfo);
        return "/attr/admin";
    }

    @RequestMapping("/admin2")
    public void admin2(Integer page, Model model, String key_name, String cate_name) {
        if (page == null) {
            page = 1;
        }
        // 获取筛选属性键分页列表
        PageInfo<Spu_attr_key> pageInfo = attrService.findSpuAttrKeyPageList(page, key_name, cate_name);
        model.addAttribute("key_name", key_name);
        model.addAttribute("cate_name", cate_name);
        model.addAttribute("pager", pageInfo);
    }

    @RequestMapping("/add")
    public void add(Model model) {
        List<Category> categoryList = categoryService.findCategory();
        model.addAttribute("categoryList", categoryList);
    }

    @RequestMapping("/save")
    public String save(Spu_attr_key spu_attr_key, Integer cate_id, String[] value_name) {
        attrService.saveAttr(spu_attr_key, cate_id, value_name);
        return "/common/ok";
    }

    @RequestMapping("/update/{key_id}")
    public String update(@PathVariable String key_id, Model model) {

        Spu_attr_key spuAttrKey = attrService.findSpuAttrKeyPageByKey_Id(key_id);

        // 获取分类列表
        List<Category> categoryList = categoryService.findCategory();

        // 判断从数据库获得的属性键下的分类是否为空值结果集，若为空则执行以下
        if (spuAttrKey.getCategoryList().isEmpty()) {
            spuAttrKey.setCategoryList(null);
        }
        model.addAttribute("key", spuAttrKey);
        model.addAttribute("categoryList", categoryList);
        return "/attr/update";
    }

    @RequestMapping("/alter")
    public String alter(Spu_attr_key spu_attr_key, Integer cate_id, String[] value_name) {

        attrService.alterSpu_attr_key(spu_attr_key, cate_id, value_name);
        return "/common/ok";
    }

    @RequestMapping("/delete")
    public String delete(String key_id, Model model) {

        try {
            attrService.deleteSpu_attr_key(key_id);
        } catch (Exception e) {
            model.addAttribute("msg", "对不起,您删除的属性键与其他关联，请检查删除关联后再删除！！!");
            return "/common/nok";
        }
        return "/common/ok";
    }

}
