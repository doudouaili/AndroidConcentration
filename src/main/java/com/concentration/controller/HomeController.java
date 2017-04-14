package com.concentration.controller;

import com.concentration.bean.InforBean;
import com.concentration.domain.service.IHomeService;
import com.concentration.bean.WorkBean;
import com.concentration.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页接口
 */
@RequestMapping("/concentrantion")
@Controller
public class HomeController {

    @Autowired
    IHomeService iHomeService;

    /**
     * 首页标题
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/LayoutTitle", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult layoutTitlePost(HttpServletRequest request) {

        List<String> list = new ArrayList<String>();
        list.add("最热");
        list.add("资讯");
        list.add("笑话");
        list.add("福利");
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(1);
        jsonResult.setData(list);
        jsonResult.setMessage("数据查找成功~~");
        return jsonResult;
    }


    /**
     * @param request
     */
    @RequestMapping(value = "/Infor", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult inforPost(HttpServletRequest request) {
        String page = request.getParameter("page");//页数
        String type = request.getParameter("type");

        JsonResult jsonResult = iHomeService.selectHomeWord(page, type);
        if (null == jsonResult) {
            jsonResult.setCode(0);
            jsonResult.setData(new ArrayList<InforBean>());
            jsonResult.setMessage("没有相应数据~~");
        } else {
            jsonResult.setCode(1);
            jsonResult.setMessage("数据查找成功~~");
        }
        return jsonResult;
    }

    /**
     * 查询专家
     *
     * @param request 专家id
     * @return
     */
    @RequestMapping(value = "/FindExpert", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult selectExpert(HttpServletRequest request) {
        String expertId = request.getParameter("expertId");
        JsonResult jsonResult = iHomeService.selectExpert(expertId);
        return jsonResult;
    }

    //

    /**
     * 查询资讯评论
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/InforComment", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult findComment(HttpServletRequest request) {
        String commentId = request.getParameter("commentId");
        String page = request.getParameter("page");

        JsonResult jsonResult = iHomeService.inforComment(commentId, page);
        return jsonResult;
    }

    /**
     * 查询笑话
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/JokeAll", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult findJokeAll(HttpServletRequest request) {
        String page = request.getParameter("page");
        JsonResult jsonResult = iHomeService.findJokeAll(page);
        return jsonResult;
    }

    /**
     * 查询笑话单个
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/JokeOne", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult findJokeOne(HttpServletRequest request) {
        String commentId = request.getParameter("jokeId");
        String page = request.getParameter("page");
        JsonResult jsonResult = iHomeService.findJokeOne(commentId, page);
        return jsonResult;
    }

}
