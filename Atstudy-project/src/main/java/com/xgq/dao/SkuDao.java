package com.xgq.dao;

import com.xgq.Bo.SkuBo;
import com.xgq.pojo.Sku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:SkuDao
 * Package: com.xgq.dao
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/6 21:48
 * @Version 1.0
 */
public interface SkuDao {
    /**
     * 获取sku对象列表
     * @return
     * @param sku_name
     * @param spu_name
     */
    List<Sku> findSkuList(@Param("sku_name") String sku_name, @Param("spu_name") String spu_name);

    /**
     * 获取商品库存列表sku根据商品id
     * @param spu_id
     * @return
     */
    List<Sku> findSkuListBySpu_id(Long spu_id);

    /**
     * 根据选择的value的具体信息获取封装数组数据
     * @param valList
     * @return
     */
    List<SkuBo> findSkuBoList(@Param("valList") List<Integer> valList);

    /**
     * 插入sku
     * @param sku
     *
     */
    void insertSku( Sku sku);

    /**
     * 删除Sku根据id
     * @param sku_id
     */
    void deleteSku(Integer sku_id);
}
