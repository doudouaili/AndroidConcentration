package com.concentration.domain.service;

import com.concentration.bean.UserBean;
import com.concentration.util.JsonResult;

/**
 * Created by ali on 2017/4/17.
 *
 */
public interface ILoginService {

    /**
     * 查询手机号是否存在
     *
     * @param user_phone
     * @return
     */
    UserBean isUserExist(String user_phone);

    /**
     * 注册用户信息存到数据库
     *
     * @param user_name
     * @param user_password
     * @param user_code
     * @param user_phone
     * @return
     */
    int addUser(String user_name, String user_password, String user_code, String user_phone);

    /**
     * 注册
     *
     * @param user_name
     * @param user_password
     * @param user_code
     * @param user_phone
     * @return
     */
    JsonResult register(String user_name, String user_password, String user_code, String user_phone);


    /**
     * 登录
     *
     * @return
     */
    JsonResult login(String user_phone, String user_password);


    /**
     * 找回密码
     *
     * @param user_phone
     * @param user_password
     * @param user_code
     * @return
     */
    JsonResult retrievePassword(String user_phone, String user_password, String user_code);
}
