package com.concentration.domain.service;

import com.concentration.bean.MessageBean;
import com.concentration.util.JsonResult;

import java.util.List;

/**
 * Created by ali on 2017/4/13.
 */
public interface IMessageService {

    /**
     * 获取消息列表
     * @return
     */
    JsonResult selectMessageAll();

}
