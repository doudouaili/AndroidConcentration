package com.concentration.bean;

import java.io.Serializable;

/**
 * Created by ali on 2017/4/27.
 */
public class ArticleNotJson implements Serializable{
    private String phoneDDIV;
    private int userId;
    private int inforId;
    private String cancelConetent;


    public String getPhoneDDIV() {
        return phoneDDIV;
    }

    public void setPhoneDDIV(String phoneDDIV) {
        this.phoneDDIV = phoneDDIV;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getInforId() {
        return inforId;
    }

    public void setInforId(int inforId) {
        this.inforId = inforId;
    }

    public String getCancelConetent() {
        return cancelConetent;
    }

    public void setCancelConetent(String cancelConetent) {
        this.cancelConetent = cancelConetent;
    }
}
