package com.concentration.bean;

import java.io.Serializable;

/**
 * Created by ali on 2017/5/2.
 */
public class RegisterJson implements Serializable {
    /*  String user_name = httpServletRequest.getParameter("user_name");
        String user_password = httpServletRequest.getParameter("user_password");
        String user_code = httpServletRequest.getParameter("user_code");
        String user_phone = httpServletRequest.getParameter("user_phone");*/

    private String user_name;
    private String user_password;
    private String user_code;
    private String user_phone;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
