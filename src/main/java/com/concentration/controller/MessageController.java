package com.concentration.controller;

import com.concentration.domain.service.IMessageService;
import com.concentration.util.JsonResult;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ali on 2017/4/13.
 */
@RequestMapping("/message")
@Controller
public class MessageController {
    @Autowired
    IMessageService iMessageService;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult seleMssage(HttpServletRequest request) {
        JsonResult jsonResult = iMessageService.selectMessageAll();
        return jsonResult;
    }
}
