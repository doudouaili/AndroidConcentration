package com.concentration.bean;

import java.io.Serializable;

/**
 * Created by ali on 2017/5/2.
 */
public class LoginJson implements Serializable{
    private String user_phone;
    private String user_password;

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
