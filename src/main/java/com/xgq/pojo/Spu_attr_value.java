package com.xgq.pojo;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;

/**
 * ClassName:Spu_attr_value
 * Package: com.xgq.pojo
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/2 14:23
 * @Version 1.0
 */
public class Spu_attr_value {
    private Integer value_id;
    private String value_name;
    private Date createtime;
    private Date updatetime;
    private String key_id;
    private String ischecked;

    public String getIschecked() {
        return ischecked;
    }

    public void setIschecked(String ischecked) {
        this.ischecked = ischecked;
    }

    private MultipartFile[] tupian;

    public MultipartFile[] getTupian() {
        return tupian;
    }

    public void setTupian(MultipartFile[] tupian) {
        this.tupian = tupian;
    }

    public Integer getValue_id() {
        return value_id;
    }

    public void setValue_id(Integer value_id) {
        this.value_id = value_id;
    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
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

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    @Override
    public String toString() {
        return "Spu_attr_value{" +
                "value_id=" + value_id +
                ", value_name='" + value_name + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", key_id='" + key_id + '\'' +
                ", tupian=" + Arrays.toString(tupian) +
                '}';
    }
}
