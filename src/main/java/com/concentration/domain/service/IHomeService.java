package com.concentration.domain.service;

import com.concentration.bean.InforBean;
import com.concentration.bean.TestInfor;
import com.concentration.bean.WorkBean;
import com.concentration.util.JsonResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章Iserver
 */
public interface IHomeService {

    /**
     * 文章标题
     *
     * @return
     */
    JsonResult articleTitle();


    /**
     * 文章首页
     *
     * @param pages     页数
     * @param type      类型
     * @param phoneDDIV 手机唯一标示
     * @param userId    用户id
     * @return
     */
    JsonResult articleInfor(int pages, int type, String phoneDDIV, int userId);

    /**
     * 点赞/收藏
     *
     * @param infor_id 文章id
     * @param user_id  用户id
     * @param state    点赞状态(0取消点赞,1点赞)
     * @param type     点赞0,收藏1
     * @return
     */
    JsonResult articleInforPraise(int infor_id, int user_id, int state, int type);


    /**
     * 对资讯不兴趣
     *
     * @param phoneDDIV      手机标识
     * @param userId         用户id
     * @param inforId        资讯id
     * @param cancelConetent 取消内容
     * @return
     */
    JsonResult articleNot(String phoneDDIV, int userId, int inforId, String cancelConetent);

    /**
     * 文章增加浏览数
     *
     * @param infor_id 资讯id
     * @param status   状态:0=浏览 1=其他
     * @return
     */
    JsonResult articleAddLookNum(int infor_id, int status);

    /**
     * 获取文章评论
     *
     * @param inforId 资讯id
     * @param userId  用户id
     * @param page    页数
     * @return
     */
    JsonResult articleInforCom(int inforId, int userId, int page);
}
