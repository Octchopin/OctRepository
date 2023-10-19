package com.xgq.pojo;

import java.util.Date;
import java.util.List;

/**
 * ClassName:Brand
 * Package: com.xgq.pojo
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/30 23:45
 * @Version 1.0
 */
public class Brand {
    private String brand_id;
    private String brand_name;
    private String brand_introduction;
    private String brand_logourl;
    private Integer sortno;
    private Date createtime;
    private Date updatetime;
    private String ischecked;

    public String getIschecked() {
        return ischecked;
    }

    public void setIschecked(String ischecked) {
        this.ischecked = ischecked;
    }

    //一个品牌对应多个分类
    private List<Category> categoryList;

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getBrand_introduction() {
        return brand_introduction;
    }

    public void setBrand_introduction(String brand_introduction) {
        this.brand_introduction = brand_introduction;
    }

    public String getBrand_logourl() {
        return brand_logourl;
    }

    public void setBrand_logourl(String brand_logourl) {
        this.brand_logourl = brand_logourl;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
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

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id='" + brand_id + '\'' +
                ", brand_name='" + brand_name + '\'' +
                ", brand_introduction='" + brand_introduction + '\'' +
                ", brand_logourl='" + brand_logourl + '\'' +
                ", sortno=" + sortno +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", categoryList=" + categoryList +
                '}';
    }
}
