package com.concentration.domain.service;

import com.concentration.bean.InforBean;
import com.concentration.bean.TestInfor;
import com.concentration.bean.WorkBean;
import com.concentration.util.JsonResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 2017/3/22.
 */
public interface IHomeService {
    List<InforBean> findInforType(String type, String page);

    int insertInfor(InforBean inforBean);

    int delectInfor(TestInfor testInfor);


    JsonResult selectHomeWord(String pages, String type);

    JsonResult selectExpert(String expertId);

    JsonResult inforComment(String inforID, String pages);


    JsonResult findJokeAll(String pages);

    JsonResult findJokeOne(String commentId, String pages);
//

}
