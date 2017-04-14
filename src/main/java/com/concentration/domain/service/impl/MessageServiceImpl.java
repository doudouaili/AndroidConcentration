package com.concentration.domain.service.impl;

import com.concentration.bean.MessageBean;
import com.concentration.domain.dao.MessageMapper;
import com.concentration.domain.service.IMessageService;
import com.concentration.util.JsonResult;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 2017/4/13.
 */
@Repository
public class MessageServiceImpl implements IMessageService {
    @Resource
    MessageMapper messageMapper;

    public JsonResult selectMessageAll() {
        List<MessageBean> messageBeen = messageMapper.selectMessageAll();

        JsonResult jsonResult = new JsonResult();
        if (messageBeen != null) {
            jsonResult.setData(messageBeen);
            jsonResult.setCode(1);
            jsonResult.setMessage("数据查询成功~~");
        } else {
            jsonResult.setData(new ArrayList());
            jsonResult.setCode(0);
            jsonResult.setMessage("没有相应数据~~");
        }
        return jsonResult;
    }
}
