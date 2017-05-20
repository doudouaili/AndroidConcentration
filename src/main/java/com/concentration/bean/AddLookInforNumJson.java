package com.concentration.bean;

import java.io.Serializable;

/**
 * Created by ali on 2017/5/1.
 */
public class AddLookInforNumJson implements Serializable{
    private int infor_id;
    private int status;

    public int getInfor_id() {
        return infor_id;
    }

    public void setInfor_id(int infor_id) {
        this.infor_id = infor_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
