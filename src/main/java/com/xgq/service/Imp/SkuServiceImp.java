package com.xgq.service.Imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgq.Bo.SkuBo;
import com.xgq.common.ComConfig;
import com.xgq.dao.SkuDao;
import com.xgq.pojo.Sku;
import com.xgq.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import java.util.List;

/**
 * ClassName:SkuServiceImp
 * Package: com.xgq.service.Imp
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/6 21:47
 * @Version 1.0
 */
@Service
public class SkuServiceImp implements SkuService {
    @Autowired
    private SkuDao skuDao;

    @Override
    public PageInfo<Sku> findPageSkuService(Integer page, String sku_name, String spu_name) {

        PageHelper.startPage(page, ComConfig.PAGE_SIZE);
        List<Sku> skuList = skuDao.findSkuList(sku_name, spu_name);
        PageInfo<Sku> pageInfo = new PageInfo<Sku>(skuList);
        return pageInfo;
    }

    @Override
    public List<Sku> findSkuList(Long spu_id) {
        return skuDao.findSkuListBySpu_id(spu_id);
    }

    @Override
    public int savaSpu(Long spu_id, Sku sku) {
        //封装数据sku_spuattr到skuBos
        List<SkuBo> skuBos = skuDao.findSkuBoList(sku.getValList());
        System.out.println(skuBos.toString());
        sku.setSku_spu_id(spu_id);
        sku.setSku_spuattr(skuBos.toString());
        System.out.println(sku);
        //获取当前商品的所有sku将刚刚拿到的sku和所有sku比较 ,有的话不能添加

        List<Sku> list = skuDao.findSkuListBySpu_id(spu_id);
        if (list != null) {
            for (Sku s : list) {
                if (s.getSku_name().equals(sku.getSku_name())) {
                    return 0;
                }
            }
        }

        skuDao.insertSku(sku);
        return 1;
    }

    @Override
    public void deleteSku(Integer sku_id) {
        skuDao.deleteSku(sku_id);
    }
}
