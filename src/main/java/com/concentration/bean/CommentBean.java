package com.concentration.bean;

/**
 * Created by ali on 2017/3/29.
 */
public class CommentBean {
    private int com_id;
    private int infor_id;
    private String com_content;
    private int user_id;
    private int com_type;
    private UserBean userBean;
    private String com_time;

    public String getCom_time() {
        return com_time;
    }

    public void setCom_time(String com_time) {
        this.com_time = com_time;
    }

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public int getInfor_id() {


            return infor_id;
    }

    public void setInfor_id(int infor_id) {
        this.infor_id = infor_id;
    }

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCom_type() {
        return com_type;
    }

    public void setCom_type(int com_type) {
        this.com_type = com_type;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
