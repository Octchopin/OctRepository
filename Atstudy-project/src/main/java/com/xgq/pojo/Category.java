package com.xgq.pojo;

import java.util.Date;
import java.util.List;

/**
 * ClassName:Category
 * Package: com.xgq.pojo
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/31 17:45
 * @Version 1.0
 */
public class Category {
    private Integer cate_id;
    private String cate_name;
    private Integer cate_sort;
    private Date createtime;
    private Date updatetime;
    private String cate_channel;
    private Integer cate_parentid;
    private List<Brand> brandList;

    //判断是否被选中的分类
    private Integer ischecked;

    public Integer getCate_id() {
        return cate_id;
    }

    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public Integer getCate_sort() {
        return cate_sort;
    }

    public void setCate_sort(Integer cate_sort) {
        this.cate_sort = cate_sort;
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

    public String getCate_channel() {
        return cate_channel;
    }

    public void setCate_channel(String cate_channel) {
        this.cate_channel = cate_channel;
    }

    public Integer getCate_parentid() {
        return cate_parentid;
    }

    public void setCate_parentid(Integer cate_parentid) {
        this.cate_parentid = cate_parentid;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public Integer getIschecked() {
        return ischecked;
    }

    public void setIschecked(Integer ischecked) {
        this.ischecked = ischecked;
    }
}
