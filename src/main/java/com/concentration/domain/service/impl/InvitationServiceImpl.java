package com.concentration.domain.service.impl;

import com.concentration.bean.InvitationBean;
import com.concentration.domain.dao.InvitationMapper;
import com.concentration.domain.service.IInvitationService;
import com.concentration.util.JsonResult;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 2017/4/13.
 */
@Repository
public class InvitationServiceImpl implements IInvitationService {
    @Resource
    InvitationMapper invitationMapper;

    public JsonResult selectInvitationAll(String pages) {
        JsonResult jsonResult = new JsonResult();
        if (pages!=null){
            int page = Integer.parseInt(pages);
            List<InvitationBean> invitationBeen = invitationMapper.selectInvitation((page - 1) * 10, page * 10);


            if (invitationBeen != null) {
                jsonResult.setData(invitationBeen);
                jsonResult.setCode(1);
                jsonResult.setMessage("数据查询成功~~");
            } else {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(0);
                jsonResult.setMessage("没有相应数据~~");
            }
        }else {
            jsonResult.setData(new ArrayList());
            jsonResult.setCode(0);
            jsonResult.setMessage("没有相应数据~~");
        }

        return jsonResult;
    }
}
