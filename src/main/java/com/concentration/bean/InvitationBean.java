package com.concentration.bean;

/**
 * Created by ali on 2017/4/13.
 */
public class InvitationBean {
    private int invitation_id;
    private int invitation_userId;
    private String invitation_title;
    private String invitation_content;
    private String invitation_img;
    private String invitation_time;
    private String invitation_number;
    private String invitation_type;


    public int getInvitation_id() {
        return invitation_id;
    }

    public void setInvitation_id(int invitation_id) {
        this.invitation_id = invitation_id;
    }

    public int getInvitation_userId() {
        return invitation_userId;
    }

    public void setInvitation_userId(int invitation_userId) {
        this.invitation_userId = invitation_userId;
    }

    public String getInvitation_title() {
        return invitation_title;
    }

    public void setInvitation_title(String invitation_title) {
        this.invitation_title = invitation_title;
    }

    public String getInvitation_content() {
        return invitation_content;
    }

    public void setInvitation_content(String invitation_content) {
        this.invitation_content = invitation_content;
    }

    public String getInvitation_img() {
        return invitation_img;
    }

    public void setInvitation_img(String invitation_img) {
        this.invitation_img = invitation_img;
    }

    public String getInvitation_time() {
        return invitation_time;
    }

    public void setInvitation_time(String invitation_time) {
        this.invitation_time = invitation_time;
    }

    public String getInvitation_number() {
        return invitation_number;
    }

    public void setInvitation_number(String invitation_number) {
        this.invitation_number = invitation_number;
    }

    public String getInvitation_type() {
        return invitation_type;
    }

    public void setInvitation_type(String invitation_type) {
        this.invitation_type = invitation_type;
    }


    private String user_photo;
    private String user_name;

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


}
