package com.concentration.bean;

import java.util.List;

/**
 * Created by ali on 2017/3/24.
 */
public class WorkBean {
    private int work_id;
    private int work_type;
    private String work_time;
    private int work_that;

    private ExpertBean expertBean;
    private com.concentration.test.InforBean inforBean;
    private JokeBean jokeBean;
    private WelfareBean welfareBean;


    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    public int getWork_type() {
        return work_type;
    }

    public void setWork_type(int work_type) {
        this.work_type = work_type;
    }

    public int getWork_that() {
        return work_that;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_that(int work_that) {
        this.work_that = work_that;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public ExpertBean getExpertBean() {
        return expertBean;
    }

    public void setExpertBean(ExpertBean expertBean) {
        this.expertBean = expertBean;
    }

    public com.concentration.test.InforBean getInforBean() {
        return inforBean;
    }

    public void setInforBean(com.concentration.test.InforBean inforBean) {
        this.inforBean = inforBean;
    }

    public JokeBean getJokeBean() {
        return jokeBean;
    }

    public void setJokeBean(JokeBean jokeBean) {
        this.jokeBean = jokeBean;
    }

    public WelfareBean getWelfareBean() {
        return welfareBean;
    }

    public void setWelfareBean(WelfareBean welfareBean) {
        this.welfareBean = welfareBean;
    }
}
