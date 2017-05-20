package com.concentration.bean;

import java.io.Serializable;

/**
 * Created by ali on 2017/3/29.
 */
public class CommentBean implements Serializable {
    private int com_id;
    private int com_user_id;
    private String com_content;

    private String com_time;
    private String com_type;
    private int com_infor_id;
    private int com_redux_userId;
    private String user_name;
    private String user_photo;


    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public int getCom_user_id() {
        return com_user_id;
    }

    public void setCom_user_id(int com_user_id) {
        this.com_user_id = com_user_id;
    }

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public String getCom_time() {
        return com_time;
    }

    public void setCom_time(String com_time) {
        this.com_time = com_time;
    }

    public String getCom_type() {
        return com_type;
    }

    public void setCom_type(String com_type) {
        this.com_type = com_type;
    }

    public int getCom_infor_id() {
        return com_infor_id;
    }

    public void setCom_infor_id(int com_infor_id) {
        this.com_infor_id = com_infor_id;
    }

    public int getCom_redux_userId() {
        return com_redux_userId;
    }

    public void setCom_redux_userId(int com_redux_userId) {
        this.com_redux_userId = com_redux_userId;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }
}
