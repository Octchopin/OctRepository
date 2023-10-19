package com.xgq.pojo;

import java.util.Date;
import java.util.List;

/**
 * ClassName:Spu
 * Package: com.xgq.pojo
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/3 13:18
 * @Version 1.0
 */
public class Spu {
    //字段表形成的实体类的成员变量
    private Long spu_id;
    private String spu_name;
    private String spu_title;
    private String spu_introduction;
    private String spu_unit;
    private Integer spu_sketchtype;
    private String spu_sketch;
    private String spu_specs;
    private Integer spu_skutype;
    private Integer spu_status;
    private Date createtime;
    private Date updatetime;
    private String  brand_id;

    //关系表
    private List<Sku> skuList;
    private List<Category> categoryList;
    private List<Spu_attr_value> spu_attr_valueList;
    private  List<Spu_attr_key> keyList;
    private  List<Spu_attr_key> sxkeyList;

    public Long getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Long spu_id) {
        this.spu_id = spu_id;
    }

    public String getSpu_name() {
        return spu_name;
    }

    public void setSpu_name(String spu_name) {
        this.spu_name = spu_name;
    }

    public String getSpu_title() {
        return spu_title;
    }

    public void setSpu_title(String spu_title) {
        this.spu_title = spu_title;
    }

    public String getSpu_introduction() {
        return spu_introduction;
    }

    public void setSpu_introduction(String spu_introduction) {
        this.spu_introduction = spu_introduction;
    }

    public String getSpu_unit() {
        return spu_unit;
    }

    public void setSpu_unit(String spu_unit) {
        this.spu_unit = spu_unit;
    }

    public Integer getSpu_sketchtype() {
        return spu_sketchtype;
    }

    public void setSpu_sketchtype(Integer spu_sketchtype) {
        this.spu_sketchtype = spu_sketchtype;
    }

    public String getSpu_sketch() {
        return spu_sketch;
    }

    public void setSpu_sketch(String spu_sketch) {
        this.spu_sketch = spu_sketch;
    }

    public String getSpu_specs() {
        return spu_specs;
    }

    public void setSpu_specs(String spu_specs) {
        this.spu_specs = spu_specs;
    }

    public Integer getSpu_skutype() {
        return spu_skutype;
    }

    public void setSpu_skutype(Integer spu_skutype) {
        this.spu_skutype = spu_skutype;
    }

    public Integer getSpu_status() {
        return spu_status;
    }

    public void setSpu_status(Integer spu_status) {
        this.spu_status = spu_status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Spu_attr_value> getSpu_attr_valueList() {
        return spu_attr_valueList;
    }

    public void setSpu_attr_valueList(List<Spu_attr_value> spu_attr_valueList) {
        this.spu_attr_valueList = spu_attr_valueList;
    }

    public List<Spu_attr_key> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<Spu_attr_key> keyList) {
        this.keyList = keyList;
    }

    public List<Spu_attr_key> getSxkeyList() {
        return sxkeyList;
    }

    public void setSxkeyList(List<Spu_attr_key> sxkeyList) {
        this.sxkeyList = sxkeyList;
    }
}
