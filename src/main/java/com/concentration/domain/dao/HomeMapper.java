package com.concentration.domain.dao;

import com.concentration.bean.InforBean;
import com.concentration.bean.TestInfor;
import com.concentration.bean.TestUser;
import com.concentration.domain.jpa.Infor;
import com.concentration.bean.ExpertBean;
import com.concentration.bean.JokeBean;
import com.concentration.bean.WelfareBean;
import com.concentration.bean.WorkBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by ali on 2017/3/22.
 */
@MapperScan
public interface HomeMapper extends Mapper<Infor> {

    @Select("select * from infor where type=#{type} order by id  asc LIMIT #{pageStart},#{pageEnd}")
    List<InforBean> findInforType(TestUser user);

    @Insert("INSERT into infor(title,time,lookNum,commentNum,img,html,type,inforType,content) " +
            "VALUES(#{title},#{time},#{lookNum},#{commentNum},#{img},#{html},#{type},#{inforType},#{content})")
    int insertInfor(InforBean inforBean);

    @Delete("DELETE FROM infor WHERE id =#{id}")
    int delectInfor(TestInfor testInfor);


    //    @Select("select*from class where teacher_id = #{id}")
//    List<ClassBean> selectClass(@Param("id") int id);

    @Select("select*from expert where order by expert_id  asc LIMIT #{pageStart},#{pageEnd}")
    List<ExpertBean> selectExpertList(@Param("pageStart") int pageStart,
                                      @Param("pageStart") int pageEnd);

    @Select("select*from expert where expert_id =#{id}")
    ExpertBean selectExpertOne(@Param("id") int id);


    @Select("select*from infor where infor_id =#{id}")
    com.concentration.test.InforBean selectInforOne(@Param("id") int id);

    @Select("select*from joke where joke_id =#{id}")
    JokeBean selectJokeOne(@Param("id") int id);

    @Select("select*from welfare where welfare_id =#{id}")
    WelfareBean selectWelfareOne(@Param("id") int id);

    @Select("select*from work where work_id =#{id}")
    WorkBean selectWorkOne(@Param("id") int id);

    @Select("select * from infor where order by infor_id  asc LIMIT #{pageStart},#{pageEnd}")
    List<InforBean> findAllInfor(@Param("pageStart") int pageStart,
                                 @Param("pageStart") int pageEnd);


    @Select("select * from welfare where order by welfare_id  asc LIMIT #{pageStart},#{pageEnd}")
    List<WelfareBean> findAllWelfare(@Param("pageStart") int pageStart,
                                     @Param("pageStart") int pageEnd);

    @Select("select * from joke where order by joke_id  asc LIMIT #{pageStart},#{pageEnd}")
    List<JokeBean> findAllJoke(@Param("pageStart") int pageStart,
                               @Param("pageStart") int pageEnd);
}
