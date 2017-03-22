package com.concentration.domain.dao;

import com.concentration.domain.jpa.User;
import org.apache.ibatis.annotations.Insert;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by ali on 2017/3/21.
 */
@MapperScan
public interface UserMapper {

    @Insert("INSERT into user(user_phone,user_password,user_photo,user_name,user_code) " +
            "VALUES(#{user_phone},#{user_password},#{user_photo},#{user_name},#{user_code})")
    int insertUser(User user);
}
