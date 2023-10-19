package com.xgq.pojo;

/**
 * ClassName:Menu
 * Package: com.xgq.pojo
 * Description:
 *
 * @Author XGQ
 * @Create 2023/7/24 21:47
 * @Version 1.0
 */
public class Menu {
    private  Integer menu_id;
    private  Integer pid;
    private  String menu_name;
    private  String menu_url;

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }
}
