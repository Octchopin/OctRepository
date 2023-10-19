package com.xgq.service.Imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xgq.common.ComConfig;
import com.xgq.dao.SpuDao;
import com.xgq.pojo.Spu;
import com.xgq.pojo.SpuVo;
import com.xgq.pojo.Spu_attr_key;
import com.xgq.pojo.Spu_attr_value;
import com.xgq.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * ClassName:SpuServiceImp
 * Package: com.xgq.service.Imp
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/3 13:32
 * @Version 1.0
 */
@Service
public class SpuServiceImp implements SpuService {
    @Autowired
    private SpuDao spuDao;

    @Override
    public PageInfo<Spu> findPageSpuList(Integer page) {
        //设置分页器参数
        PageHelper.startPage(page, ComConfig.PAGE_SIZE);
        //获取要分页的列表对象
        List<Spu> spuList = spuDao.findSpuList();
        //创建分页对象进行分页操作
        PageInfo<Spu> pageInfo = new PageInfo<>(spuList);
        return pageInfo;
    }

    @Override
    public List<Spu_attr_key> findSupKeyByCate_id(Integer cate_id) {
        return spuDao.findSpuKeyByCate_id(cate_id);
    }

    @Override
    public List<Spu_attr_key> findSupKeyGuigeById(Integer cate_id) {
        return spuDao.findSupKeyGuigeById(cate_id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSpu(Spu spu, Integer[] value_ids, SpuVo spuVo) {
        //先插入标准商品单元的参数
        spuDao.insertSpu(spu);
        //获取插入spu商品对象的spu_id;
        Long spu_id = spu.getSpu_id();
        if (value_ids != null && value_ids.length > 0) {
            //插入筛选属性值和商品的关系
            spuDao.insertSpuKey(value_ids, spu_id);
        }

        //添加商品的规格属性值
        System.out.println(spuVo.getKeyList());
        for (Spu_attr_key key : spuVo.getKeyList()) {

            List<Spu_attr_value> valueList = key.getValueList();


            for (Spu_attr_value valueByKey : valueList) {

                //插入规格属性键对应的属性值
                valueByKey.setKey_id(key.getKey_id());
                spuDao.insertValue(valueByKey);
                Integer value_id = valueByKey.getValue_id();
                //封装收集key--value下的图片集的字符串缓冲区
                StringBuilder sb = new StringBuilder();
                MultipartFile[] tupian = valueByKey.getTupian();
                String spu_attr_imgs = null;
                //给每个图片进行上传服务器云盘中
                if (tupian != null) {
                    for (MultipartFile mf : tupian) {
                        String filename = mf.getOriginalFilename();
                        if (!filename.isEmpty() && !filename.equals("") && filename != null) {
                            filename = UUID.randomUUID().toString().replace("-", "") + filename.substring(filename.lastIndexOf("."));
                            try {
                                mf.transferTo(new File("D://pic/", filename));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }


                        }
                        sb.append(",");
                        sb.append(filename);

                    }
                    spu_attr_imgs = sb.substring(1);
                    //插入规格属性值和商品的关系表
                    spuDao.insertSpu_ValueIncludeImgs(spu_attr_imgs, value_id, spu_id);
                }


            }

        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sxjiaSpu(Long spu_id, Integer spu_status) {
        spuDao.updateSpu_status(spu_id, spu_status);
        if (spu_status ==-1) {
            spuDao.deleteSpu_Value(spu_id);
            spuDao.deleteSpuBySpu_status(spu_status);
        }
    }

    @Override
    public Spu findSpuBySpuId(Long spu_id) {
        Spu spu = spuDao.findSpuBySpuId(spu_id);

        //获取商品的筛选和规格属性键
        List<Spu_attr_key> sxSpuKey = spuDao.findKey_Value_Spu(spu_id);
        List<Spu_attr_key> spuKey = spuDao.findsxKey_Value_Spu(spu_id);
        if (sxSpuKey!=null) {
            for (Spu_attr_key key : sxSpuKey) {
                String key_id = key.getKey_id();
             List<Spu_attr_value>  valueList= spuDao.findsxValueByKeyId(key_id);
             key.setValueList(valueList);
            }
        }

        spu.setSxkeyList(sxSpuKey);
        spu.setKeyList(spuKey);

        return spu;
    }

    @Override
    public void alterSpu(Spu spu) {
        spuDao.insertSpu(spu);
    }

    @Override
    public Spu findSpuById(Long spu_id) {
       return spuDao.findSpuBySpuId(spu_id);
    }
}
