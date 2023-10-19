package com.xgq.service;

import com.github.pagehelper.PageInfo;
import com.xgq.pojo.Spu_attr_key;

import java.util.List;

/**
 * ClassName:AttrService
 * Package: com.xgq.service
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/2 14:17
 * @Version 1.0
 */
public interface AttrService {
    /**
     * 获取筛选属性键分页列表根据传入的page，同时关注的是搜索条件
     * @param page
     * @param key_name
     * @param cate_name
     * @return
     */
    PageInfo<Spu_attr_key> findSpuAttrKeyPageList(Integer page, String key_name, String cate_name);

    /**
     * 保存属性键和属性值包括分类类
     * @param spu_attr_key
     * @param cate_id
     * @param value_name
     */
    void saveAttr(Spu_attr_key spu_attr_key, Integer cate_id, String[] value_name);

    /**
     * 获取筛选属性对象根据传入字符串id
     * @param key_id
     * @return
     */
    Spu_attr_key findSpuAttrKeyPageByKey_Id(String key_id);

    /**
     * 更新筛选属性键
     * @param spu_attr_key
     * @param cate_id
     * @param value_name
     */
    void alterSpu_attr_key(Spu_attr_key spu_attr_key, Integer cate_id, String[] value_name);

    /**
     * 删除属性键
     * @param key_id
     */
    void deleteSpu_attr_key(String key_id) throws Exception;

    /**
     * 获取筛选属性键分页列表根据传入的page
     * @param page
     * @return
     */
    PageInfo<Spu_attr_key> findSpuAttrKeyPageList(Integer page);

    /**
     * 根据商品id获取商品的规格属性键值
     * @param spu_id
     * @return
     */
    List<Spu_attr_key> findSpuAttrKeyBySpu_id(Long spu_id);
}
