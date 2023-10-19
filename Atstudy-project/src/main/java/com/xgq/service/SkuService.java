package com.xgq.service;

import com.github.pagehelper.PageInfo;
import com.xgq.pojo.Sku;

import java.util.List;

/**
 * ClassName:SkuService
 * Package: com.xgq.service
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/6 21:47
 * @Version 1.0
 */
public interface SkuService {
    /**
     * 查询sku数据并分页
     * @param page
     * @param sku_name
     * @param spu_name
     * @return
     */
    PageInfo<Sku> findPageSkuService(Integer page, String sku_name, String spu_name);

    /**
     * 根据spu_id获取sku列表
     * @param spu_id
     * @return
     */
    List<Sku> findSkuList(Long spu_id);

    /**
     * 添加具体的sku
     * @param spu_id
     * @param sku
     * @return
     */
    int savaSpu(Long spu_id, Sku sku);

    /**
     * 删除Sku对象根据传入的id
     * @param sku_id
     */
    void deleteSku(Integer sku_id);
}
