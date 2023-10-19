package com.xgq.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xgq.pojo.Admin;
import com.xgq.pojo.Brand;
import com.xgq.pojo.Permission;
import com.xgq.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

/**
 * ClassName:brandController
 * Package: com.xgq.controller
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/30 23:43
 * @Version 1.0
 */
@Controller
@RequestMapping("/brand")
public class brandController {

    @Autowired
    private BrandService brandService;

    @RequestMapping("/admin")
    public void admin(Integer page, Model model) {

        if (page == null) {
            page = 1;
        }
        PageInfo<Brand> pageInfo = brandService.findBrand(page);

        model.addAttribute("pager", pageInfo);

    }

    @RequestMapping("/add")
    public void add(Model model) {


    }

    @RequestMapping("/save")
    public String save(Brand brand, MultipartFile brand_img) throws IOException {
        String Filename = brand_img.getOriginalFilename();
        if (Filename != null && Filename != "") {
            Filename = UUID.randomUUID().toString().replace("-", "") + Filename.substring(Filename.lastIndexOf("."));
            brand.setBrand_logourl(Filename);
            brand_img.transferTo(new File("D://pic", Filename));
        }


        //调用插入操作
        brandService.savaBrand(brand);
        return "/common/ok";

    }

    @RequestMapping("/delete")
    public String delete(String brand_id) {

        //删除品牌与分类的关联关系及品牌

        brandService.delete(brand_id);


        return "/common/ok";
    }

    @RequestMapping("/update")
    public void update(String brand_id, Model model) {
        //获取一个品牌信息根据传入的id
        Brand brand = brandService.findOneBrand(brand_id);
        model.addAttribute("brand", brand);

    }
    @RequestMapping("/alter")
    public String alter(Brand brand, MultipartFile brand_img,Integer [] cate_ids) throws IOException {

      //更新新的brand数据包括文件上传
        String filename = brand_img.getOriginalFilename();


        if (!filename.isEmpty()) {
            filename=UUID.randomUUID().toString().replace("-","")+filename.substring(filename.lastIndexOf("."));

            brand.setBrand_logourl(filename);
            brand_img.transferTo(new File("D://pic",filename));
        }

        //执行更新操作
        brandService.updateBrand(brand);



        //更新分类与品牌的关系分两步
        //第一步删除原有的关系
        brandService.deleteBrandCategories(cate_ids,brand);
        return "/common/ok";
    }
}
