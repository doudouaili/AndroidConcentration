package com.concentration.bean;

/**
 * Created by ali on 2017/4/26.
 */
public class ArticleNotInterestedBean {
    private int nia_id;
    private String nia_phone_tag;
    private int user_id;
    private int infor_id;

    private String can_nai;

    public String getCan_nai() {
        return can_nai;
    }

    public void setCan_nai(String can_nai) {
        this.can_nai = can_nai;
    }

    public int getNia_id() {
        return nia_id;
    }

    public void setNia_id(int nia_id) {
        this.nia_id = nia_id;
    }

    public String getNia_phone_tag() {
        return nia_phone_tag;
    }

    public void setNia_phone_tag(String nia_phone_tag) {
        this.nia_phone_tag = nia_phone_tag;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getInfor_id() {
        return infor_id;
    }

    public void setInfor_id(int infor_id) {
        this.infor_id = infor_id;
    }
}
