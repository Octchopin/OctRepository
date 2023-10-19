package com.xgq.service;

import com.github.pagehelper.PageInfo;
import com.xgq.pojo.Spu;
import com.xgq.pojo.SpuVo;
import com.xgq.pojo.Spu_attr_key;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:SpuService
 * Package: com.xgq.service
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/3 13:32
 * @Version 1.0
 */
public interface SpuService {

    /**
     * 获取分页商品规格列表
     * @param page
     * @return
     */
    PageInfo<Spu> findPageSpuList(Integer page);

    /**
     * 获取筛选属性键根据分类id
     * @param cate_id
     * @return
     */
    List<Spu_attr_key> findSupKeyByCate_id(Integer cate_id);

    /**
     * 获取分类的规格属性键
     * @param cate_id
     * @return
     */
    List<Spu_attr_key> findSupKeyGuigeById(Integer cate_id);


    /**
     * 插入spu对象数据
     * 插入spu和筛选属性键关系
     * 插入spu和属性值的关系
     * @param spu
     * @param value_ids
     * @param spuVo
     */
    void saveSpu(Spu spu, Integer[] value_ids, SpuVo spuVo);

    /**
     * 根据传入的商品id更新商品列表里商品状态码
     * @param spu_id
     * @param spu_status
     */
    void sxjiaSpu( Long spu_id,Integer spu_status);

    /**
     * 根据商品id获取商品
     * @param spu_id
     * @return
     */
    Spu findSpuBySpuId(Long spu_id);

    /**
     * 插入spu商品数据到spu中
     * @param spu
     */
    void alterSpu(Spu spu);

    /**
     * 获取spu对象根据id
     * @param spu_id
     * @return
     */
    Spu findSpuById(Long spu_id);
}
