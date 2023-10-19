package com.xgq.dao;

import com.xgq.pojo.Spu;
import com.xgq.pojo.Spu_attr_key;
import com.xgq.pojo.Spu_attr_value;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:SpuDao
 * Package: com.xgq.dao
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/3 13:18
 * @Version 1.0
 */
public interface SpuDao {
    /**
     * 获取要分页的列表对象
     * @return
     */
    List<Spu> findSpuList();

    /**
     * 根据分类id找到对应的筛选属性键及值
     * @param cate_id
     * @return
     */
    List<Spu_attr_key> findSpuKeyByCate_id(Integer cate_id);

    /**
     * 根据一个属性键对多个属性值，获取对应的属性值列表，筛选属性键和对应的属性值
     * @return
     */
    List<Spu_attr_key> findValueListByKey();

    /**
     * 获取数据库中分类为规格的属性键
     * @param cate_id
     * @return
     */
    List<Spu_attr_key> findSupKeyGuigeById(Integer cate_id);

    /**
     * 插入标准商品单元的内容
     * @param spu
     */
    void insertSpu(Spu spu);

    /**
     * 插入筛选属性值和spu的关系数据
     * @param value_ids
     * @param spu_id
     */
    void insertSpuKey(@Param("value_ids") Integer[] value_ids,@Param("spu_id") Long spu_id);

    /**
     * 插入由一个规格属性键得属性值列表，到数据库的属性值列表中
     * @param valueByKey
     */
    void insertValue(Spu_attr_value valueByKey);

    /**
     * 插入一个商品对应的规格属性值关系数据到数据库，包括图片集
     * @param spu_attr_imgs
     * @param value_id
     * @param spu_id
     */
    void insertSpu_ValueIncludeImgs(@Param("spu_attr_imgs") String spu_attr_imgs,@Param("value_id") Integer value_id, @Param("spu_id") Long spu_id);

    /**
     * 根据传入的商品id更新商品列表里商品状态码
     * @param spu_id
     * @param spu_status
     */
    void updateSpu_status(@Param("spu_id") Long spu_id,@Param("spu_status") Integer spu_status);

    /**
     * 根据id获取商品
     * @param spu_id
     * @return
     */
    Spu findSpuBySpuId(Long spu_id);

    /**
     * 获取规格属性键
     * @return
     * @param spu_id
     */
   List<Spu_attr_key> findKey_Value_Spu(Long spu_id);
   /**
     * 获取筛选属性键
     * @return
    * @param spu_id
     */
   List<Spu_attr_key> findsxKey_Value_Spu(Long spu_id);

    /**
     * 根据筛选属性键的id获取筛选属性值，包括ischecked
     * @param key_id
     * @return
     */
    List<Spu_attr_value> findsxValueByKeyId(String key_id);

    /**
     * 删除spu与value的关联根据id
     * @param spu_id
     */
    void deleteSpu_Value(Long spu_id);

    /**
     * 删除spu对象，如果status等于-1
     * @param spu_status
     */
    void deleteSpuBySpu_status(Integer spu_status);
}
