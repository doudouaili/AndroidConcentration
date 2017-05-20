package com.concentration.bean;

import java.io.Serializable;

/**
 * Created by ali on 2017/4/27.
 */
public class ArticleInforPraiseJson implements Serializable{
    private int infor_id;
    private int user_id;
    private int state;
    private int type;

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
