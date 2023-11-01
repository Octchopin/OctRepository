package com.xgq.controller;

import com.github.pagehelper.PageInfo;
import com.xgq.pojo.*;
import com.xgq.service.BrandService;
import com.xgq.service.CategoryService;
import com.xgq.service.SpuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * ClassName:SpuController
 * Package: com.xgq.controller
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/3 12:40
 * @Version 1.0
 */
@Controller
@RequestMapping("/spu")
public class SpuController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SpuService spuService;

    @RequestMapping("/admin")
    public void admin(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) {
        System.out.println("ccc");
        //获取分页商品规格
        PageInfo<Spu> pageInfo = spuService.findPageSpuList(page);
        model.addAttribute("pager", pageInfo);
    }

    @RequestMapping("/add")
    public void add(Model model) {
        //获取品牌列表
        List<Brand> brandList = brandService.findBrandList();
        //获取分类列表
        List<Category> categoryList = categoryService.findCategory();
        model.addAttribute("brandList", brandList);
        model.addAttribute("categoryList", categoryList);

    }

    //一下json格式的响应前端客户端是响应ajax
    @RequestMapping("/getKeyList/{cate_id}")
    @ResponseBody
    public List<Spu_attr_key> getKeyList(@PathVariable("cate_id") Integer cate_id) {
        List<Spu_attr_key> keyList = spuService.findSupKeyGuigeById(cate_id);
        return keyList;
    }

    @RequestMapping("/getsxKeyList/{cate_id}")
    @ResponseBody
    public List<Spu_attr_key> getsxKeyList(@PathVariable("cate_id") Integer cate_id) {
        List<Spu_attr_key> keyList = spuService.findSupKeyByCate_id(cate_id);

        return keyList;


    }

    @RequestMapping("/save")
    public String save(Spu spu, Integer[] value_ids, SpuVo spuVo) {

        spuService.saveSpu(spu, value_ids, spuVo);


        return "/common/ok";
    }

    @RequestMapping("/sxjia")
    public String sxjia(Long spu_id, Integer spu_status) {


        //根据传入的商品id更新商品列表里商品状态码

        spuService.sxjiaSpu(spu_id, spu_status);

        return "redirect:admin";
    }

    @RequestMapping("/update/{spu_id}")
    public String update(@PathVariable Long spu_id, Model model) {
        //根据id获取spu商品
        Spu spu = spuService.findSpuBySpuId(spu_id);
        System.out.println(spu);
        model.addAttribute("spu", spu);
        return "/spu/update";
    }

    @RequestMapping("/alter")
    public String alter(Spu spu, Model model) {
        spuService.alterSpu(spu);
        return "/common/ok";
    }


}
