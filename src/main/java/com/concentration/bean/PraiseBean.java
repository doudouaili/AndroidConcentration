package com.concentration.bean;

/**
 * Created by ali on 2017/5/2.
 */
public class PraiseBean {
    private int praise_id;
    private int infor_id;
    private int user_id;
    private String infor_type;
    private String praise_state;
    private String praise_add_time;

    public int getPraise_id() {
        return praise_id;
    }

    public void setPraise_id(int praise_id) {
        this.praise_id = praise_id;
    }

    public int getInfor_id() {
        return infor_id;
    }

    public void setInfor_id(int infor_id) {
        this.infor_id = infor_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getInfor_type() {
        return infor_type;
    }

    public void setInfor_type(String infor_type) {
        this.infor_type = infor_type;
    }

    public String getPraise_state() {
        return praise_state;
    }

    public void setPraise_state(String praise_state) {
        this.praise_state = praise_state;
    }

    public String getPraise_add_time() {
        return praise_add_time;
    }

    public void setPraise_add_time(String praise_add_time) {
        this.praise_add_time = praise_add_time;
    }
}

