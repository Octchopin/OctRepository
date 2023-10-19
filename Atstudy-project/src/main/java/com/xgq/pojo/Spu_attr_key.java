package com.xgq.pojo;

import java.util.Date;
import java.util.List;

/**
 * ClassName:Spu_attr_key
 * Package: com.xgq.pojo
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/2 14:09
 * @Version 1.0
 */
public class Spu_attr_key {
    private String key_id;
    private String key_name;
    private Integer key_issku;
    private Integer key_ishigh;
    private Date createtime;
    private Date updatetime;
    private List<Category> categoryList;
    //一对多，一个属性键对应多个属性值
    private List<Spu_attr_value> valueList;

    public List<Spu_attr_value> getValueList() {
        return valueList;
    }

    public void setValueList(List<Spu_attr_value> valueList) {
        this.valueList = valueList;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public Integer getKey_issku() {
        return key_issku;
    }

    public void setKey_issku(Integer key_issku) {
        this.key_issku = key_issku;
    }

    public Integer getKey_ishigh() {
        return key_ishigh;
    }

    public void setKey_ishigh(Integer key_ishigh) {
        this.key_ishigh = key_ishigh;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
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

    @Override
    public String toString() {
        return "Spu_attr_key{" +
                "key_id='" + key_id + '\'' +
                ", key_name='" + key_name + '\'' +
                ", key_issku=" + key_issku +
                ", key_ishigh=" + key_ishigh +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", categoryList=" + categoryList +
                ", valueList=" + valueList +
                '}';
    }
}
