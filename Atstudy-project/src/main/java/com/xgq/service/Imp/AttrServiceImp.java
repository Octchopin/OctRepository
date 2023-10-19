package com.xgq.service.Imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgq.common.ComConfig;
import com.xgq.dao.AttrDao;
import com.xgq.pojo.Spu_attr_key;
import com.xgq.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * ClassName:AttrServiceImp
 * Package: com.xgq.service.Imp
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/2 14:17
 * @Version 1.0
 */
@Service
public class AttrServiceImp implements AttrService {
    @Autowired
    private AttrDao attrDao;
    @Override
    public PageInfo<Spu_attr_key> findSpuAttrKeyPageList(Integer page, String key_name, String cate_name) {
        //先设置分页参数器
        PageHelper.startPage(page, ComConfig.PAGE_SIZE-4);
        //获取要分页的列表--------筛选属性键列表
        List<Spu_attr_key>  spu_attr_keyList=attrDao.findSpuAttrKeyPageListLikeName(key_name,cate_name);
        //将设置好的分页参数和分页对象传入分页功能对象中进行分页
        PageInfo<Spu_attr_key> pageInfo = new PageInfo<>(spu_attr_keyList);
        return pageInfo ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAttr(Spu_attr_key spu_attr_key, Integer cate_id, String[] value_name) {
        //生成key_id
        String key_id=new Date().getTime()+"";
       spu_attr_key.setKey_id(key_id);

       //插入到spu_attr_key数据库
        attrDao.insertSpu_attr_key(spu_attr_key);
        //插入分类与key关系表
        attrDao.insertSpu_attr_key_category(cate_id,spu_attr_key.getKey_id());
        //插入属性值到数值表spu_attr_value
        if (value_name != null&&value_name.length>0 ) {
            attrDao.insertSpu_attr_Value(value_name,spu_attr_key.getKey_id());
        }

    }

    @Override
    public Spu_attr_key findSpuAttrKeyPageByKey_Id(String key_id) {
        return attrDao.findSpuAttrKeyByKey_Id(key_id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void alterSpu_attr_key(Spu_attr_key spu_attr_key, Integer cate_id, String[] value_name) {


        //更新spu_attr_key对象根据id
        attrDao.updateSpu_attr_key(spu_attr_key);
        //删除之前的分类与key关系表，根据固定不变原有的id
        attrDao.deleteSpu_attr_key_category(spu_attr_key.getKey_id());

        attrDao.insertSpu_attr_key_category(cate_id,spu_attr_key.getKey_id());
        //插入属性值到数值表spu_attr_value
        if (value_name != null&&value_name.length>0 ) {
            //新删除原有一对多关系属性键对属性值于表value
            attrDao.deleteSpu_attr_Value(spu_attr_key.getKey_id());
            //再插入新的属性键值在value表
            attrDao.insertSpu_attr_Value(value_name,spu_attr_key.getKey_id());
        }
    }

    @Override
    public void deleteSpu_attr_key(String key_id) throws  Exception{
        attrDao.deleteSpu_attr_key(key_id);
    }

    @Override
    public PageInfo<Spu_attr_key> findSpuAttrKeyPageList(Integer page) {
        //先设置分页参数器
        PageHelper.startPage(page, ComConfig.PAGE_SIZE);
        //获取要分页的列表--------筛选属性键列表
        List<Spu_attr_key>  spu_attr_keyList=attrDao.findSpuAttrKeyPageList();
        //将设置好的分页参数和分页对象传入分页功能对象中进行分页
        PageInfo<Spu_attr_key> pageInfo = new PageInfo<>(spu_attr_keyList);
        return pageInfo ;
    }

    @Override
    public List<Spu_attr_key> findSpuAttrKeyBySpu_id(Long spu_id) {
        return attrDao.findSpuAttrKeyBySpu_Id(spu_id);
    }
}
