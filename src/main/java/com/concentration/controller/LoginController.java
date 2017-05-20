package com.concentration.controller;

import com.concentration.bean.FindPassWordJson;
import com.concentration.bean.LoginJson;
import com.concentration.bean.RegisterJson;
import com.concentration.domain.service.ILoginService;
import com.concentration.util.JsonResult;
import com.concentration.util.RespCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录模块
 */
@RequestMapping("/restful")
@Controller
public class LoginController {


    @Autowired
    ILoginService iLoginService;

    /**
     * 注册接口
     *
     * @param json user_name:用户名
     *             user_password:密码
     *             user_code:验证码
     *             user_phone:手机号
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userRegister(@RequestBody RegisterJson json) {

        JsonResult register = iLoginService.register(json.getUser_name(), json.getUser_password(),
                json.getUser_code(), json.getUser_phone());
        return register;
    }


    /**
     * 用户登录
     *
     * @param json user_phone 手机号
     *             user_password 密码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userLogin(@RequestBody LoginJson json) {

        JsonResult login = iLoginService.login(json.getUser_phone(), json.getUser_password());
        return login;
    }

    /**
     * 找回密码
     *
     * @param json user_phone:手机号
     *             user_password:密码
     *             user_code:验证码
     * @return
     */
    @RequestMapping(value = "/findpassword", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult userFindPassWord(@RequestBody FindPassWordJson json) {

        JsonResult jsonResult = iLoginService.retrievePassword(json.getUser_phone(),
                json.getUser_password(), json.getUser_code());
        return jsonResult;
    }
}
