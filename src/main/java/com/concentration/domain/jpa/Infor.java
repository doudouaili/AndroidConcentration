package com.concentration.domain.jpa;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by ali on 2017/3/23.
 */
@Table(name = "infor")
public class Infor {
    @Id
    private int id;
    @Column(name = "title")
    private String title;

    @Column(name = "time")
    private String time;
    @Column(name = "lookNum")
    private int  lookNum;

    @Column(name = "commentNum")
    private int commentNum;

    @Column(name = "img")
    private String img;

    @Column(name = "html")
    private String html;

    @Column(name = "type")
    private int type;

    @Column(name = "inforType")
    private int inforType;

    @Column(name = "content")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLookNum() {
        return lookNum;
    }

    public void setLookNum(int lookNum) {
        this.lookNum = lookNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getInforType() {
        return inforType;
    }

    public void setInforType(int inforType) {
        this.inforType = inforType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
