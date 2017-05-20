package com.concentration.bean;

import java.io.Serializable;

/**
 * Created by ali on 2017/4/27.
 */
public class ArticleinforJson implements Serializable{
    private int type;
    private int userId;
    private int page;
    private String phoneDDIV;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getPhoneDDIV() {
        return phoneDDIV;
    }

    public void setPhoneDDIV(String phoneDDIV) {
        this.phoneDDIV = phoneDDIV;
    }
}
