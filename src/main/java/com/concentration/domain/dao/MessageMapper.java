package com.concentration.domain.dao;

import com.concentration.bean.MessageBean;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by ali on 2017/4/13.
 */
@MapperScan
public interface MessageMapper {

    @Select("SELECT * FROM message")
    List<MessageBean> selectMessageAll();
}
