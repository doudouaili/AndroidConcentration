package com.concentration.bean;

/**
 * Created by ali on 2017/3/24.
 */
public class JokeBean {
    private int joke_id;
    private String joke_from;
    private String joke_content;
    private String joke_img;
    private String joke_title;

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
