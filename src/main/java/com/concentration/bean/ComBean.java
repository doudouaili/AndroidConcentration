package com.concentration.bean;

/**
 * Created by ali on 2017/3/30.
 */
public class ComBean {
    private int jokeCom_id;
    private int joke_id;
    private int user_id;
    private int jokeCom_type;
    private String jokeCom_time;
    private String jokeCom_content;
    private UserBean userBean;

    public int getJokeCom_id() {
        return jokeCom_id;
    }

    public void setJokeCom_id(int jokeCom_id) {
        this.jokeCom_id = jokeCom_id;
    }

    public int getJoke_id() {
        return joke_id;
    }

    public void setJoke_id(int joke_id) {
        this.joke_id = joke_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getJokeCom_type() {
        return jokeCom_type;
    }

    public void setJokeCom_type(int jokeCom_type) {
        this.jokeCom_type = jokeCom_type;
    }

    public String getJokeCom_time() {
        return jokeCom_time;
    }

    public void setJokeCom_time(String jokeCom_time) {
        this.jokeCom_time = jokeCom_time;
    }

    public String getJokeCom_content() {
        return jokeCom_content;
    }

    public void setJokeCom_content(String jokeCom_content) {
        this.jokeCom_content = jokeCom_content;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
