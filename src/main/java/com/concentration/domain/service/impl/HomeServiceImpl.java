package com.concentration.domain.service.impl;

import com.concentration.bean.*;
import com.concentration.domain.dao.HomeMapper;
import com.concentration.domain.service.IHomeService;
import com.concentration.util.JsonResult;
import com.concentration.util.TimeUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章serverImpl
 */
@Repository
public class HomeServiceImpl implements IHomeService {

    @Resource
    HomeMapper homeMapper;

    public JsonResult articleTitle() {
        List<String> list = new ArrayList<String>();
        list.add("推荐");
        list.add("博客");
        list.add("问答");
        list.add("科技");
        list.add("技术");
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(1);
        jsonResult.setData(list);
        jsonResult.setMessage("数据查找成功~~");
        return jsonResult;
    }

    public JsonResult articleInfor(int pages, int type, String phoneDDIV, int userId) {

        JsonResult jsonResult = new JsonResult();

        if (homeMapper.selectArticleForPhone(phoneDDIV) == null) {
            homeMapper.insertArticleNotInterested(phoneDDIV, userId);
        }

        List<InforArticleBean> iNforArticele = homeMapper.findINforArticele(type, (pages - 1) * 10, pages * 10);

        if (iNforArticele != null) {
            for (int i = 0; i < iNforArticele.size(); i++) {
                ArticleNotInterestedBean bean = homeMapper.selectArticleForInforId(iNforArticele.get(i).getInfor_id(), phoneDDIV);
                if (bean != null) {
                    iNforArticele.remove(i);
                }
            }
            jsonResult.setData(iNforArticele);
            jsonResult.setCode(1);
            jsonResult.setMessage("数据查询成功~~");
        } else {
            jsonResult.setData(new ArrayList());
            jsonResult.setCode(0);
            jsonResult.setMessage("没有更多数据~~");
        }

        return jsonResult;
    }

    public JsonResult articleInforPraise(int inforId, int userId, int statein, int clType) {
        JsonResult jsonResult = new JsonResult();
        int inforType = homeMapper.findInforType(inforId);
        String systemTiem = TimeUtil.getSystemTiem();
        int praiseState = 0;
        int collectState = 0;
        if (clType == 0) { //点赞
            PraiseBean inforPraiseForUserId = homeMapper.findInforPraiseForUserId(inforId, userId);
            if (inforPraiseForUserId != null) {//存在
                praiseState = homeMapper.upadteInforPraise(inforId, userId, inforType, statein, systemTiem, inforPraiseForUserId.getPraise_id());
            } else {
                praiseState = homeMapper.insertInforPraise(inforId, userId, inforType, statein, systemTiem);
            }

            if (praiseState > 0) {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(1);
                if (statein == 0) {
                    jsonResult.setMessage("取消成功~~");
                } else {
                    jsonResult.setMessage("点赞成功~~");
                }

            } else {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(1);
                jsonResult.setMessage("点赞失败~~");
            }
        } else {//收藏

            CollectBean collectBean = homeMapper.findInforCollectForUserId(inforId, userId);
            if (collectBean != null) {//存在
                collectState = homeMapper.upadteInforCollect(inforId, userId, inforType, statein, systemTiem, collectBean.getCollect_id());
            } else {
                collectState = homeMapper.insertInforCollect(inforId, userId, inforType, statein, systemTiem);
            }

            if (collectState > 0) {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(1);
                if (statein == 1) {
                    jsonResult.setMessage("收藏成功~~");
                } else {
                    jsonResult.setMessage("取消成功~~");
                }
            } else {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(0);
                jsonResult.setMessage("参数异常~~");
            }
        }
        return jsonResult;
    }

    public JsonResult articleNot(String phoneDDIV, int userId, int inforId, String cancelConetent) {
        JsonResult jsonResult = new JsonResult();
        if (phoneDDIV != null && cancelConetent != null) {
            int tag = 0;
            ArticleNotInterestedBean bean = homeMapper.selectArticleForPhone(phoneDDIV);
            if (bean != null) {
                tag = homeMapper.upadteArticle(phoneDDIV, userId, inforId, cancelConetent, bean.getNia_id());
            } else {
                tag = homeMapper.insertArticleNotInterestedAll(phoneDDIV, userId, inforId, cancelConetent);
            }
            if (tag > 0) {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(1);
                jsonResult.setMessage("不在推送此类信息~~");
            } else {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(0);
                jsonResult.setMessage("参数异常~~");
            }

        } else {
            jsonResult.setData(new ArrayList());
            jsonResult.setCode(0);
            jsonResult.setMessage("参数异常~~");
        }
        return jsonResult;
    }

    public JsonResult articleAddLookNum(int infor_id, int status) {
        JsonResult jsonResult = new JsonResult();
        if (status == 0) {
            int i = homeMapper.selectInforLookNum(infor_id);
            int i1 = homeMapper.updateAddLookNum(infor_id, i + 1);
            if (i1 > 0) {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(1);
                jsonResult.setMessage("修改成功~~");
            } else {
                jsonResult.setData(new ArrayList());
                jsonResult.setCode(0);
                jsonResult.setMessage("修改失败~~");
            }
        }
        return jsonResult;
    }

    public JsonResult articleInforCom(int inforId, int userId, int page) {

        JsonResult jsonResult = new JsonResult();
        ComBean comBean = new ComBean();

        PraiseBean inforPraiseForUserId = homeMapper.findInforPraiseForUserId(inforId, userId);//收藏

        if (inforPraiseForUserId != null) {
            comBean.setIsPraise(Integer.parseInt(inforPraiseForUserId.getPraise_state()));
        } else {
            comBean.setIsPraise(0);
        }

        CollectBean inforCollectForUserId = homeMapper.findInforCollectForUserId(inforId, userId);//点赞

        if (inforCollectForUserId != null) {
            comBean.setIsCollect(Integer.parseInt(inforPraiseForUserId.getPraise_state()));
        } else {
            comBean.setIsCollect(0);
        }

        List<CommentBean> commentBeen = homeMapper.selectInforCom(inforId, (page - 1) * 10, page * 10);


        comBean.setCommentBeanList(commentBeen);
        List<ComBean> comBeen = new ArrayList<ComBean>();

        comBeen.add(comBean);
        jsonResult.setData(comBeen);
        jsonResult.setCode(1);
        jsonResult.setMessage("数据查询成功~~");
        return jsonResult;
    }

}
