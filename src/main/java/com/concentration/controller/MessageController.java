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
 * 消息
 */
@RequestMapping("/message")
@Controller
public class MessageController {
    @Autowired
    IMessageService iMessageService;

    /**
     * 获取消息列表
     *
     * @return
     */
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult seleMssage() {
        JsonResult jsonResult = iMessageService.selectMessageAll();
        return jsonResult;
    }
}
