package com.concentration.domain.service.impl;

import com.concentration.bean.InforBean;
import com.concentration.bean.TestInfor;
import com.concentration.bean.TestUser;
import com.concentration.domain.dao.HomeMapper;
import com.concentration.domain.service.IHomeService;
import com.concentration.bean.ExpertBean;
import com.concentration.bean.JokeBean;
import com.concentration.bean.WelfareBean;
import com.concentration.bean.WorkBean;
import com.concentration.util.JsonResult;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页service
 */
@Repository
public class HomeServiceImpl implements IHomeService {

    @Resource
    HomeMapper homeMapper;

    public List<InforBean> findInforType(String type, String page) {
        if ("".equals(type) && "".equals(page)) {
            return null;
        }
        int types = Integer.parseInt(type);
        int pages = Integer.parseInt(page);
        TestUser testUser = new TestUser();
        testUser.setPageEnd(10);
        testUser.setPageStart((pages - 1) * 10);
        testUser.setType(types);
        return homeMapper.findInforType(testUser);
    }

    public int insertInfor(InforBean inforBean) {
        return homeMapper.insertInfor(inforBean);
    }

    public int delectInfor(TestInfor testInfor) {
        return homeMapper.delectInfor(testInfor);
    }


    public JsonResult selectHomeWord(String pages, String types) {
        int page = Integer.parseInt(pages);
        int type = Integer.parseInt(types);
        JsonResult jsonResult = new JsonResult();
        switch (type) {
            case 1:
                ArrayList<WorkBean> workBeen = selectWorkAll(page);
                jsonResult.setData(workBeen);
                break;
            case 2:
                List<InforBean> allInfor = homeMapper.findAllInfor(page, (page - 1) * 10);
                jsonResult.setData(allInfor);
                break;
            case 3:
                List<WelfareBean> allWelfare = homeMapper.findAllWelfare(page, (page - 1) * 10);
                jsonResult.setData(allWelfare);
                break;
            case 4:
                List<JokeBean> allJoke = homeMapper.findAllJoke(page, (page - 1) * 10);
                jsonResult.setData(allJoke);
                break;
        }
        return jsonResult;
    }

    public JsonResult selectExpert(String expertId) {
        int expert_id = Integer.parseInt(expertId);
        ExpertBean expertBean = homeMapper.selectExpertOne(expert_id);
        ArrayList<ExpertBean> teacherBeen = new ArrayList<ExpertBean>();
        teacherBeen.add(expertBean);

        JsonResult jsonResult = new JsonResult();
        if (expertBean!=null){
            jsonResult.setData(teacherBeen);
            jsonResult.setCode(1);
            jsonResult.setMessage("数据查询成功~~");
        }else {
            jsonResult.setData(new ArrayList());
            jsonResult.setCode(0);
            jsonResult.setMessage("没有相应数据~~");
        }
        return jsonResult;
    }

    private ArrayList<WorkBean> selectWorkAll(int page) {
        ArrayList<WorkBean> teacherBeen = new ArrayList<WorkBean>();

        for (int i = page; i < page + 10; i++) {
            WorkBean workBean = homeMapper.selectWorkOne(i);
            if (workBean != null) {
                com.concentration.test.InforBean inforBean = homeMapper.selectInforOne(workBean.getWork_type());
                workBean.setInforBean(inforBean);
                WelfareBean welfareBean = homeMapper.selectWelfareOne(workBean.getWork_type());
                workBean.setWelfareBean(welfareBean);
                JokeBean jokeBean = homeMapper.selectJokeOne(workBean.getWork_type());
                workBean.setJokeBean(jokeBean);
                ExpertBean expertBean = homeMapper.selectExpertOne(workBean.getWork_type());
                workBean.setExpertBean(expertBean);
                teacherBeen.add(workBean);
            }
        }
        return teacherBeen;
    }
}
