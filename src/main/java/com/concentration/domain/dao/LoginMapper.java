package com.concentration.domain.dao;

import com.concentration.bean.UserBean;
import com.concentration.domain.jpa.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by ali on 2017/4/17.
 */
@MapperScan
public interface LoginMapper {

    @Select("select * from user where user_phone = #{id}")
    UserBean isUserExist(@Param("id") String id);


    @Insert("insert into user(user_name,user_password,user_code,user_phone,user_photo)values(#{user_name}," +
            "#{user_password}," +
            "#{user_code}," +
            "#{user_phone}," +
            "#{user_photo})")
    int addUser(@Param("user_name") String user_name,
                @Param("user_password") String user_password,
                @Param("user_code") String user_code,
                @Param("user_phone") String user_phone,
                @Param("user_photo") String user_photo);


    /**
     * 根据手机号和密码查询是否存在
     *
     * @return 用户信息
     */
    @Select("select * from user where user_phone=#{user_phone} and user_password=#{user_password}")
    UserBean userExists(@Param("user_phone") String user_phone,
                        @Param("user_password") String user_password);

    /**
     * 找回密码
     *
     * @param user_phone
     * @param user_password
     * @param user_code
     * @return
     */
    @Update("UPDATE user SET user_password=#{user_password} ,user_code =#{user_code} WHERE user_phone =#{user_phone}")
    int userFindPassWord(@Param("user_password") String user_password,
                              @Param("user_code") String user_code,
                              @Param("user_phone") String user_phone);

}
