package com.concentration.util;

import java.io.Serializable;

/**
 * Created by ali on 2017/3/22.
 */
public class JsonResult<T> implements Serializable {
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
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
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

    public JsonResult(int code, String message, T data) {
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
    }


}
