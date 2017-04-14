package com.concentration.domain.dao;

import com.concentration.bean.InvitationBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by ali on 2017/4/13.
 */
@MapperScan
public interface InvitationMapper {

    @Select("select * from invitation i,user u where i.invitation_id=u.user_id order by i.invitation_id  asc LIMIT #{pageStart},#{pageEnd}")
    List<InvitationBean> selectInvitation(@Param("pageStart") int pageStart,
                                          @Param("pageEnd") int pageEnd);
}
