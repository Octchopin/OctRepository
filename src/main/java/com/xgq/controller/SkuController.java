package com.xgq.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.regexp.internal.RE;
import com.xgq.pojo.Sku;
import com.xgq.pojo.Spu;
import com.xgq.pojo.Spu_attr_key;
import com.xgq.service.AttrService;
import com.xgq.service.SkuService;
import com.xgq.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * ClassName:SkuController
 * Package: com.xgq.controller
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/6 21:42
 * @Version 1.0
 */
@Controller
@RequestMapping("/sku")
public class SkuController {
    @Autowired
    private SkuService skuService;

    @Autowired
    private AttrService attrService;
    @Autowired
    private SpuService spuService;

    @RequestMapping("/admin")
    public void admin(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model, String spu_name, String sku_name) {

        PageInfo<Sku> skuList = skuService.findPageSkuService(page, sku_name, spu_name);
        model.addAttribute("spu_name", spu_name);
        model.addAttribute("sku_name", sku_name);
        model.addAttribute("pager", skuList);
    }

    @RequestMapping("/add")
    public void add(Long spu_id,Model model) {
        //根据spu_id获取所有的sku的列表
        List<Sku> skuList = skuService.findSkuList(spu_id);

        //根据spu_id获取规格属性键值
        List<Spu_attr_key> keyList=attrService.findSpuAttrKeyBySpu_id(spu_id);

        //根据spu_id获取spu商品对象
        Spu spu=spuService.findSpuById(spu_id);

        model.addAttribute("keyList",keyList);
        model.addAttribute("skuList",skuList);
        model.addAttribute("spu",spu);

    }
    @RequestMapping("/save")
    public String save(Long spu_id,Sku sku,Model model) {
        System.out.println(sku);
        System.out.println(sku.getValList());
       int flag=skuService.savaSpu(spu_id,sku);
        if (flag == 0) {
            model.addAttribute("msg","当前商品的规格已存在，添加失败！！！");
            return "/common/nok";
        }
        return "redirect:add?spu_id="+spu_id;
    }
    @RequestMapping("/delete")
    public String delete(Long spu_id,Integer sku_id) {
       skuService.deleteSku(sku_id);
        return "/common/ok";
    }

}
