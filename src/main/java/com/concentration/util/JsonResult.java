package com.concentration.util;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ali on 2017/3/22.
 */
public class JsonResult implements Serializable {
    /**
     * 是否成功
     */
    private int code;
    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private List data;


    public List  getData() {
        return data;
    }

    public void setData(List  data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

 /*   public JsonResult(int code, String message, List  data) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public JsonResult(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public JsonResult(int code) {
        this.code = code;
    }*/


}
