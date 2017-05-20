package com.concentration.bean;

/**
 * Created by ali on 2017/5/2.
 */
public class CollectBean {
    private int collect_id;
    private  int infor_id;
    private String infor_type;
    private int user_id;
    private String add_time;
    private String collect_state;

    public int getCollect_id() {
        return collect_id;
    }

    public void setCollect_id(int collect_id) {
        this.collect_id = collect_id;
    }

    public int getInfor_id() {
        return infor_id;
    }

    public void setInfor_id(int infor_id) {
        this.infor_id = infor_id;
    }

    public String getInfor_type() {
        return infor_type;
    }

    public void setInfor_type(String infor_type) {
        this.infor_type = infor_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getCollect_state() {
        return collect_state;
    }

    public void setCollect_state(String collect_state) {
        this.collect_state = collect_state;
    }
}
