package com.xgq.Bo;

/**
 * ClassName:SkuBo
 * Package: com.xgq.Bo
 * Description:
 *
 * @Author XGQ
 * @Create 2023/8/7 20:02
 * @Version 1.0
 */
public class SkuBo {
    private Long spu_id;
    private String key_id;
    private  String key_name;
    private Integer value_id;
    private String value_name;

    public Long getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Long spu_id) {
        this.spu_id = spu_id;
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

    @Override
    public String toString() {
        return "{" +
                "\"spu_id\":" + spu_id +
                ", \"key_id\":\"" + key_id + '\"' +
                ", \"key_name\":\"" + key_name + '\"' +
                ", \"value_id\":\"" + value_id +
                ", \"value_name\":\"" + value_name + '\"' +
                '}';
    }
}
