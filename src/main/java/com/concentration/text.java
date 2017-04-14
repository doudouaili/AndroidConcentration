package com.concentration;

import com.concentration.bean.*;
import com.concentration.domain.dao.HomeMapper;
import com.concentration.domain.dao.InvitationMapper;
import com.concentration.domain.service.IHomeService;
import com.concentration.domain.service.IUserService;
import com.concentration.util.JsonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ali on 2017/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class text {

    @Autowired
    IUserService iUserService;

    @Autowired
    IHomeService iHomeService;

    @Autowired
    HomeMapper mapper;

    @Autowired
    InvitationMapper invitationMapper;

    @Test
    public void show() {
        List<InvitationBean> invitationBeen = invitationMapper.selectInvitation(0,10);
        System.out.println(invitationBeen.size());


      /*  JsonResult jokeOne = iHomeService.findJokeOne("11", "1");
        int code = jokeOne.getCode();*/


//        List<CommentBean> commAll = mapper.findCommAll(1, 1, 10);




   /*     InforBean inforBean = new InforBean();
        inforBean.setType(6);
        inforBean.setInforType(2);

        inforBean.setHtml("https://www.jbtm.org//family//jthtml//20170323//article_4025.html");*/

       /* inforBean.setTitle("原生Android也能做Web开发了");
        inforBean.setContent("AndServer是一个Android端的Web服务器，类似Apache或者Tomcat，" +
                "但又有不同，它是一个普通的Android Library，Android项目Gradle远程依赖或者添加Jar包皆可引入该项目，" +
                "然后就通过正常Android开发一样开发App了。");*/
       /* inforBean.setTitle("android阿里面试题锦集");
        inforBean.setContent("前几天突然就经历了阿里android实习内推的电面，感觉有好多以前看过的东西都忘记了，然后又复习了一下，找了很多阿里的面经总结了一下，希望对大家有帮助，下面的知识点大多出自 android开发艺术探索，而且很多都是我自己的总结，方便自己记忆，如果想深入可以去看看这本书。");*/
      /*  inforBean.setTitle("进程间通信--IPC");
        inforBean.setContent("进程间通信(Inter-Process Communication),简称IPC,就是指进程与进程之间进行通信.一般来说,一个app只有一个进程,但是可能会有多个线程,所以我们用得比较多的是多线程通信,比如handler,AsyncTask.");


        for (int i = 1; i < 9; i++) {
            inforBean.setCommentNum(3 + i);
            inforBean.setLookNum(21 + i);
            inforBean.setImg("http://112.74.104.213:8080/image/image" + i + ".jpg");
            inforBean.setTime("2017-0" + (2 + i) + "-23 09:21");
            iHomeService.insertInfor(inforBean);
        }*/
    }

    @Test
    public void delectInfor() {

        /*TestInfor testInfor = new TestInfor();
        testInfor.setId(16);
        int i = iHomeService.delectInfor(testInfor);
        System.out.println("删除了" + i);*/
    }


    @Test
    public void inforselect() {
        /*TestInfor testInfor = new TestInfor();
        testInfor.setId(1);
        TeacherBean teacherBean = mapper.selectTeacher(1);

        List<ClassBean> classBeen = mapper.selectClass(1);
        teacherBean.setClassBeanList(classBeen);

        ArrayList<TeacherBean> teacherBeen = new ArrayList<TeacherBean>();
        teacherBeen.add(teacherBean);

        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(1);
        jsonResult.setMessage("水电费");
        jsonResult.setData(teacherBeen);

        ObjectMapper mapper = new ObjectMapper();

        // Convert object to JSON string
        try {
            String Json =  mapper.writeValueAsString(jsonResult);
            System.out.println(Json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void text() {
        ArrayList<WorkBean> teacherBeen = new ArrayList<WorkBean>();
        for (int i = 14; i < 25; i++) {
            WorkBean workBean = mapper.selectWorkOne(i);
            if (workBean != null) {
                com.concentration.test.InforBean inforBean = mapper.selectInforOne(workBean.getWork_type());
                workBean.setInforBean(inforBean);
                WelfareBean welfareBean = mapper.selectWelfareOne(workBean.getWork_type());
                workBean.setWelfareBean(welfareBean);
                JokeBean jokeBean = mapper.selectJokeOne(workBean.getWork_type());
                workBean.setJokeBean(jokeBean);
               /* if (4 == workBean.getWork_that()) {
                    List<ExpertBean> expertBeen = mapper.selectExpertList();
                    workBean.setExpertBeanList(expertBeen);
                } else {
                    workBean.setExpertBeanList(new ArrayList<ExpertBean>());
                }*/
                teacherBeen.add(workBean);
            }
        }


        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(1);
        jsonResult.setMessage("水电费");
        jsonResult.setData(teacherBeen);
        ObjectMapper mapper = new ObjectMapper();

        try {
            String Json = mapper.writeValueAsString(jsonResult);
            System.out.println(Json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
