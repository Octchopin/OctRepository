package com.xgq.dao;

import com.xgq.pojo.Category;
import com.xgq.pojo.Spu_attr_key;
import com.xgq.pojo.Spu_attr_value;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName:AttrDao
 * Package: com.xgq.dao
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/2 14:17
 * @Version 1.0
 */
public interface AttrDao {
    /**
     * 获取要分页的列表--------筛选属性键列表
     * @return
     *
     */
    List<Spu_attr_key> findSpuAttrKeyPageList();

    /**
     * 获取属性键的分类列表
     * @return
     */
    List<Category> findKeyCategoryList();

    /**
     * 插入筛选属性键数据到列表数据
     * @param spu_attr_key
     */
    void insertSpu_attr_key(Spu_attr_key spu_attr_key);

    /**
     * 插入分类与key关系表
     * @param cate_id
     * @param key_id
     */
    void insertSpu_attr_key_category(@Param("cate_id") Integer cate_id,@Param("key_id") String key_id);

    /**
     * 插入属性值到数值表spu_attr_value
     * @param value_name
     * @param key_id
     */
    void insertSpu_attr_Value(@Param("value_names") String[] value_name,@Param("key_id") String key_id);

    /**
     * 根据id获取筛选属性键对象
     * @param key_id
     * @return
     */
    Spu_attr_key findSpuAttrKeyByKey_Id(String key_id);
    /**
     * 根据id获取筛选属性键的属性值列表，一对多
     * @param key_id
     * @return
     */
  List<Spu_attr_value>  findSpuKeyValueList(String key_id);

    /**
     * 更新spu_attr_key对象根据id
     * @param spu_attr_key
     */
    void updateSpu_attr_key(Spu_attr_key spu_attr_key);

    /**
     * 删除之前的分类与key关系表，根据原有的id
     * @param key_id
     */
    void deleteSpu_attr_key_category(String key_id);

    /**
     * 新删除原有一对多关系属性键对属性值于表value
     * @param key_id
     */
    void deleteSpu_attr_Value(String key_id);

    /**
     * 根据id删除对应的属性键
     * @param key_id
     */
    void deleteSpu_attr_key(String key_id);

    /**
     * 搜索框分页属性键数据
     * @param key_name
     * @param cate_name
     * @return
     */
    List<Spu_attr_key> findSpuAttrKeyPageListLikeName(@Param("key_name") String key_name,@Param("cate_name") String cate_name);

    /**
     * 根据商品的id获取对应规格属性键
     * @param spu_id
     * @return
     */
    List<Spu_attr_key> findSpuAttrKeyBySpu_Id(Long spu_id);
}
