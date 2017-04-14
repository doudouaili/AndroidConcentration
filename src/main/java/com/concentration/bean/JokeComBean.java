package com.concentration.bean;

import java.util.List;

/**
 * Created by ali on 2017/3/30.
 */
public class JokeComBean {
    private int joke_id;
    private String joke_from;
    private String joke_content;
    private String joke_img;
    private String joke_title;
    private String joke_type;
    private String joke_html;

    private List<ComBean> comBean;

    public List<ComBean> getComBean() {
        return comBean;
    }

    public void setComBean(List<ComBean> comBean) {
        this.comBean = comBean;
    }

    public String getJoke_html() {
        return joke_html;
    }

    public void setJoke_type(String joke_type) {
        this.joke_type = joke_type;
    }

    public String getJoke_type() {
        return joke_type;
    }

    public void setJoke_html(String joke_html) {
        this.joke_html = joke_html;
    }

    public int getJoke_id() {
        return joke_id;
    }

    public void setJoke_id(int joke_id) {
        this.joke_id = joke_id;
    }

    public String getJoke_from() {
        return joke_from;
    }

    public void setJoke_from(String joke_from) {
        this.joke_from = joke_from;
    }

    public String getJoke_content() {
        return joke_content;
    }

    public void setJoke_content(String joke_content) {
        this.joke_content = joke_content;
    }

    public String getJoke_img() {
        return joke_img;
    }

    public void setJoke_img(String joke_img) {
        this.joke_img = joke_img;
    }

    public void setJoke_title(String joke_title) {
        this.joke_title = joke_title;
    }

    public String getJoke_title() {
        return joke_title;
    }




}
