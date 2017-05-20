package com.concentration.controller;

import com.concentration.bean.*;
import com.concentration.domain.service.IHomeService;
import com.concentration.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 文章接口
 */
@RequestMapping("/concentrantion")
@Controller
public class HomeController {

    @Autowired
    IHomeService iHomeService;

    /**
     * 首页标题
     *
     * @return
     */
    @RequestMapping(value = "/articletitle", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult articleTitle() {
        JsonResult jsonResult = iHomeService.articleTitle();
        return jsonResult;
    }

    /**
     * @param json page:页数
     *             type:类型
     *             资讯:1
     *             博客:2
     *             问答:3
     *             科技:4
     *             技术:5
     *             phoneDDIV:手机的唯一标示
     *             userId:用户id
     * @return
     */
    @RequestMapping(value = "/articleinfor", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult articleInfor(@RequestBody ArticleinforJson json) {
        JsonResult jsonResult = iHomeService.articleInfor(json.getPage(), json.getType(), json.getPhoneDDIV(), json.getUserId());
        return jsonResult;
    }

    /**
     * 文章评论
     *
     * @param json
     * @return
     */
    @RequestMapping(value = "/articleinfor/com", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult articleInforCom(@RequestBody InforComJson json) {
        JsonResult jsonResult = iHomeService.articleInforCom(json.getInforId(), json.getUserId(), json.getPage());
        return jsonResult;
    }

    /**
     * 点赞/收藏
     * infor_id:文章id
     * user_id:用户id
     * state:点赞状态(0取消点赞,1点赞)
     * type:点赞0,收藏1
     */
    @RequestMapping(value = "/articleinfor/praisecollect", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult articleInforPraise(@RequestBody ArticleInforPraiseJson json) {
        JsonResult jsonResult = iHomeService.articleInforPraise(json.getInfor_id(), json.getUser_id(), json.getState(), json.getType());
        return jsonResult;
    }


    /**
     * 对资讯不兴趣
     *
     * @param json phoneDDIV  手机标识
     *             userId   用户id
     *             inforId  资讯id
     *             cancelConetent  取消内容
     * @return
     */
    @RequestMapping(value = "/articleinfor/cancelinfor", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult articleNot(@RequestBody ArticleNotJson json) {
        JsonResult jsonResult = iHomeService.articleNot(json.getPhoneDDIV(), json.getUserId(), json.getInforId(), json.getCancelConetent());
        return jsonResult;
    }


    /**
     * 文章增加浏览数
     *
     * @param json infor_id 资讯id
     *             status  状态:0=浏览 1=其他
     * @return
     */
    @RequestMapping(value = "/articleinfor/addlook", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult articleAddLookNum(@RequestBody AddLookInforNumJson json) {
        JsonResult jsonResult = iHomeService.articleAddLookNum(json.getInfor_id(), json.getStatus());
        return jsonResult;
    }
    
}
