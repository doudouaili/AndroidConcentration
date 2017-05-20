package com.concentration.bean;

import java.io.Serializable;

/**
 * Created by ali on 2017/5/1.
 */
public class InforComJson implements Serializable {
    private int inforId;
    private int userId;
    private int page;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getInforId() {
        return inforId;
    }

    public void setInforId(int inforId) {
        this.inforId = inforId;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
