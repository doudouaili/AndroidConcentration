package com.concentration.controller;

import com.concentration.domain.service.IInvitationService;
import com.concentration.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ali on 2017/4/13.
 */
@RequestMapping("/invitation")
@Controller
public class InvitationController {

    @Autowired
    IInvitationService iInvitationService;

    /**
     * 查询所以帖子
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/invita", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult findJokeOne(HttpServletRequest request) {
        String page = request.getParameter("page");
        JsonResult jsonResult = iInvitationService.selectInvitationAll(page);
        return jsonResult;
    }
}
