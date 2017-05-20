package com.concentration;

import com.concentration.bean.*;
import com.concentration.domain.dao.HomeMapper;
import com.concentration.domain.dao.InvitationMapper;
import com.concentration.domain.dao.LoginMapper;
import com.concentration.domain.service.IHomeService;
import com.concentration.domain.service.IUserService;
import com.concentration.util.AESHelperUtil;
import com.concentration.util.JsonResult;
import com.concentration.util.RespCode;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @Resource
    LoginMapper loginMapper;

    private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapper = null;

    @Test
    public void show() {
        JsonResult jsonResult1 = iHomeService.articleAddLookNum(1, 0);

//        JsonResult jsonResult =  iHomeService.articleInfor(1,1,"OOOOOO",0);
//        JsonResult jsonResult = iHomeService.articleNot("OOOOOO", 0, 1, "垃圾内容11");

//        JsonResult jsonResult = iHomeService.articleInforPraise(2,1,0,0);

        JsonResult jsonResult = iHomeService.articleInforCom(1, 1, 1);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
            jsonGenerator.writeObject(jsonResult);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
