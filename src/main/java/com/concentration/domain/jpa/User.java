package com.concentration.domain.jpa;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ali on 2017/3/21.
 */
@Table(name = "user")
public class User {
    @Id
    private int user_id;
    @Column(name = "user_phone")
    private String user_phone;

    @Column(name = "user_password")
    private String user_password;

    @Column(name = "user_photo")
    private String user_photo;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "user_code")
    private String user_code;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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

    public String getUser_photo() {
        return user_photo;
    }

    public void setUser_photo(String user_photo) {
        this.user_photo = user_photo;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }
}
