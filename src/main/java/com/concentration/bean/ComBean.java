package com.concentration.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ali on 2017/3/30.
 */
public class ComBean implements Serializable{
    private int isCollect;
    private int isPraise;
    private List<CommentBean> commentBeanList;

    public int getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(int isCollect) {
        this.isCollect = isCollect;
    }

    public int getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(int isPraise) {
        this.isPraise = isPraise;
    }

    public List<CommentBean> getCommentBeanList() {
        return commentBeanList;
    }

    public void setCommentBeanList(List<CommentBean> commentBeanList) {
        this.commentBeanList = commentBeanList;
    }
}

