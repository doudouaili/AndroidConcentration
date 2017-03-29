package com.concentration.controller;

import com.concentration.bean.TestUser;
import com.concentration.bean.UserBean;
import com.concentration.domain.jpa.User;
import com.concentration.util.JsonResult;
import com.concentration.util.RespCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ali on 2017/3/21.
 */
@RequestMapping("/restful")
@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

 /*   @RequestMapping(value = "/textPost", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult testPost(@RequestBody TestUser user) {
        System.out.println("请求了" + user.getName());
        return new JsonResult<Object>("用户或者密码错误", RespCode.SUCCESS);
    }

    @RequestMapping(value = "/textPosts", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult testPost(HttpServletRequest httpServletRequest) {
        String name = httpServletRequest.getParameter("name");
        System.out.println("请求了" + name);
        return new JsonResult<Object>("用户或者密码错误", RespCode.SUCCESS);
    }*/

}
