package com.xgq.pojo;

import java.util.Date;
import java.util.List;

/**
 * ClassName:Sku
 * Package: com.xgq.pojo
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/3 13:22
 * @Version 1.0
 */
public class Sku {
    //字段表形成的实体类的成员变量
    private Long sku_id;
    private Long sku_spu_id;
    private String sku_name;
    private String sku_spuattr;
    private Integer sku_price;
    private Integer sku_originalprice;
    private Integer sku_costprice;
    private Integer sku_quantity;
    private Integer sortno;
    private Date createtime;
    private Date updatetime;
//一个商品对应一个商品规格，一个商品规格对应多个商品
    private  Spu spu;


    private List<Integer> valList;

    public List<Integer> getValList() {
        return valList;
    }

    public void setValList(List<Integer> valList) {
        this.valList = valList;
    }

    public Long getSku_id() {
        return sku_id;
    }

    public void setSku_id(Long sku_id) {
        this.sku_id = sku_id;
    }

    public Long getSku_spu_id() {
        return sku_spu_id;
    }

    public void setSku_spu_id(Long sku_spu_id) {
        this.sku_spu_id = sku_spu_id;
    }

    public String getSku_name() {
        return sku_name;
    }

    public void setSku_name(String sku_name) {
        this.sku_name = sku_name;
    }

    public String getSku_spuattr() {
        return sku_spuattr;
    }

    public void setSku_spuattr(String sku_spuattr) {
        this.sku_spuattr = sku_spuattr;
    }

    public Integer getSku_price() {
        return sku_price;
    }

    public void setSku_price(Integer sku_price) {
        this.sku_price = sku_price;
    }

    public Integer getSku_originalprice() {
        return sku_originalprice;
    }

    public void setSku_originalprice(Integer sku_originalprice) {
        this.sku_originalprice = sku_originalprice;
    }

    public Integer getSku_costprice() {
        return sku_costprice;
    }

    public void setSku_costprice(Integer sku_costprice) {
        this.sku_costprice = sku_costprice;
    }

    public Integer getSku_quantity() {
        return sku_quantity;
    }

    public void setSku_quantity(Integer sku_quantity) {
        this.sku_quantity = sku_quantity;
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

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "sku_id=" + sku_id +
                ", sku_spu_id=" + sku_spu_id +
                ", sku_name='" + sku_name + '\'' +
                ", sku_spuattr='" + sku_spuattr + '\'' +
                ", sku_price=" + sku_price +
                ", sku_originalprice=" + sku_originalprice +
                ", sku_costprice=" + sku_costprice +
                ", sku_quantity=" + sku_quantity +
                ", sortno=" + sortno +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", spu=" + spu +
                '}';
    }
}
