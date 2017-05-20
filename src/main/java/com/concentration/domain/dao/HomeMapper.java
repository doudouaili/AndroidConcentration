package com.concentration.domain.dao;

import com.concentration.bean.*;
import com.concentration.domain.jpa.Infor;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 文章dao
 */
@MapperScan
public interface HomeMapper extends Mapper<Infor> {

    /**
     * 根据类型查询文章
     *
     * @param type      类型
     * @param pageStart 开始页
     * @param pageEnd   结束页
     * @return
     */
    @Select("select *from infor_article left join user on infor_article.infor_user_id =user.user_id where title_type =#{type} ORDER BY infor_id LIMIT #{pageStart},#{pageEnd}")
    List<InforArticleBean> findINforArticele(@Param("type") int type,
                                             @Param("pageStart") int pageStart,
                                             @Param("pageEnd") int pageEnd);

    /**
     * 根据文章id查询文章类型
     *
     * @param id 文章id
     * @return
     */
    @Select("SELECT infor_type from infor_article WHERE infor_id = #{id}")
    int findInforType(@Param("id") int id);

    /**
     * 文章点赞
     *
     * @param infor_id        文章id
     * @param user_id         用户id
     * @param infor_type      文章类型
     * @param praise_state    点赞状态
     * @param praise_add_time 点赞时间
     * @return
     */
    @Insert("INSERT INTO infor_praise(infor_id,user_id,infor_type,praise_state,praise_add_time)\n" +
            " VALUES (#{infor_id},#{user_id},#{infor_type},#{praise_state},#{praise_add_time})")
    int insertInforPraise(@Param("infor_id") int infor_id,
                          @Param("user_id") int user_id,
                          @Param("infor_type") int infor_type,
                          @Param("praise_state") int praise_state,
                          @Param("praise_add_time") String praise_add_time);

    /**
     * 根据用户id查询点赞表以前是否点赞
     *
     * @param infor_id 文章id
     * @param user_id  用户id
     * @return
     */
    @Select("SELECT * from infor_praise WHERE infor_id = #{infor_id} AND user_id=#{user_id}")
    PraiseBean findInforPraiseForUserId(@Param("infor_id") int infor_id,
                                        @Param("user_id") int user_id);

    /**
     * 文章点赞 更新
     *
     * @param infor_id        文章id
     * @param user_id         用户id
     * @param infor_type      文章类型
     * @param praise_state    点赞状态
     * @param praise_add_time 点赞时间
     * @param praise_id       id
     * @return
     */
    @Update("UPDATE infor_praise SET infor_id=#{infor_id},user_id =#{user_id},infor_type=#{infor_type},praise_state=#{praise_state},praise_add_time=#{praise_add_time}  where praise_id=#{praise_id}")
    int upadteInforPraise(@Param("infor_id") int infor_id,
                          @Param("user_id") int user_id,
                          @Param("infor_type") int infor_type,
                          @Param("praise_state") int praise_state,
                          @Param("praise_add_time") String praise_add_time,
                          @Param("praise_id") int praise_id);

    /**
     * 文章收藏
     *
     * @param infor_id        文章id
     * @param user_id         用户id
     * @param infor_type      文章类型
     * @param praise_state    点赞状态
     * @param praise_add_time 点赞时间
     * @return
     */
    @Insert("INSERT INTO infor_collect(infor_id,user_id,infor_type,collect_state,add_time)\n" +
            " VALUES (#{infor_id},#{user_id},#{infor_type},#{praise_state},#{praise_add_time})")
    int insertInforCollect(@Param("infor_id") int infor_id,
                           @Param("user_id") int user_id,
                           @Param("infor_type") int infor_type,
                           @Param("praise_state") int praise_state,
                           @Param("praise_add_time") String praise_add_time);

    /**
     * 文章收藏 更新
     *
     * @param infor_id      文章id
     * @param user_id       用户id
     * @param infor_type    文章类型
     * @param collect_state 点赞状态
     * @param add_time      点赞时间
     * @return
     */
    @Update("UPDATE infor_collect SET infor_id=#{infor_id},user_id =#{user_id},infor_type=#{infor_type},collect_state=#{collect_state},add_time=#{add_time} where collect_id=#{collect_id}")
    int upadteInforCollect(@Param("infor_id") int infor_id,
                           @Param("user_id") int user_id,
                           @Param("infor_type") int infor_type,
                           @Param("collect_state") int collect_state,
                           @Param("add_time") String add_time,
                           @Param("collect_id") int collect_id);


    /**
     * 根据用户id查询收藏表以前是否收藏
     *
     * @param infor_id 文章id
     * @param user_id  用户id
     * @return
     */
    @Select("SELECT *  from infor_collect WHERE infor_id = #{infor_id} AND user_id=#{user_id}")
    CollectBean findInforCollectForUserId(@Param("infor_id") int infor_id,
                                          @Param("user_id") int user_id);

    /**
     * 插入手机标识
     *
     * @param nia_phone_tag 手机标识
     * @param user_id       用户id
     * @return
     */
    @Insert("INSERT INTO article_not_interested (nia_phone_tag,user_id) VALUES(#{nia_phone_tag},#{user_id});")
    int insertArticleNotInterested(@Param("nia_phone_tag") String nia_phone_tag,
                                   @Param("user_id") int user_id);

    /**
     * 插入article_not_interested表 不感兴趣
     *
     * @param nia_phone_tag 手机标识
     * @param user_id       用户id
     * @param infor_id      资讯id
     * @param can_nai       不感兴趣内容
     * @return
     */
    @Insert("INSERT INTO article_not_interested (nia_phone_tag,user_id,infor_id,can_nai) VALUES(#{nia_phone_tag},#{user_id},#{infor_id},#{can_nai})")
    int insertArticleNotInterestedAll(@Param("nia_phone_tag") String nia_phone_tag,
                                      @Param("user_id") int user_id,
                                      @Param("infor_id") int infor_id,
                                      @Param("can_nai") String can_nai);

    /**
     * 判断手机标识是否存在,根据手机标识查询
     *
     * @param nia_phone_tag 手机标识
     * @return
     */
    @Select("SELECT * FROM article_not_interested WHERE nia_phone_tag =#{nia_phone_tag}")
    ArticleNotInterestedBean selectArticleForPhone(@Param("nia_phone_tag") String nia_phone_tag);

    /**
     * article_not_interested表,根据资讯id和手机标识查询
     *
     * @param infor_id      资讯id
     * @param nia_phone_tag 手机标识
     * @return
     */
    @Select("SELECT * FROM article_not_interested WHERE infor_id =#{infor_id} and nia_phone_tag=#{nia_phone_tag}")
    ArticleNotInterestedBean selectArticleForInforId(@Param("infor_id") int infor_id,
                                                     @Param("nia_phone_tag") String nia_phone_tag);

    /**
     * 根据nia_id更新article_not_interested表
     *
     * @param nia_phone_tag 手机标识
     * @param user_id       用户id
     * @param infor_id      资讯id
     * @param nia_id        id
     * @return
     */
    @Update("UPDATE article_not_interested SET nia_phone_tag=#{nia_phone_tag},user_id =#{user_id},infor_id=#{infor_id},can_nai=#{can_nai} where nia_id=#{nia_id}")
    int upadteArticle(@Param("nia_phone_tag") String nia_phone_tag,
                      @Param("user_id") int user_id,
                      @Param("infor_id") int infor_id,
                      @Param("can_nai") String can_nai,
                      @Param("nia_id") int nia_id);

    /**
     * 更新文章的浏览数
     *
     * @param infor_id 资讯id
     * @return
     */
    @Update("UPDATE infor_article SET infor_praise_num =#{infor_praise_num} WHERE infor_id=#{infor_id}")
    int updateAddLookNum(@Param("infor_id") int infor_id,
                         @Param("infor_praise_num") int infor_praise_num);

    /**
     * 根据资讯id获取阅读数
     *
     * @param infor_id 资讯id
     * @return
     */
    @Select("SELECT infor_praise_num FROM infor_article WHERE infor_id =#{infor_id}")
    int selectInforLookNum(@Param("infor_id") int infor_id);

    /**
     * 获取所以资讯评论
     *
     * @param infor_id  文章id
     * @param pageStart
     * @param pageEnd
     * @return
     */
    @Select("select *from infor_comment left join user on infor_comment.com_user_id =user.user_id where com_infor_id =#{infor_id} ORDER BY com_id LIMIT #{pageStart},#{pageEnd}")
    List<CommentBean> selectInforCom(@Param("infor_id") int infor_id,
                                     @Param("pageStart") int pageStart,
                                     @Param("pageEnd") int pageEnd);






  /*  @Insert("INSERT into infor(title,time,lookNum,commentNum,img,html,type,inforType,content) " +
            "VALUES(#{title},#{time},#{lookNum},#{commentNum},#{img},#{html},#{type},#{inforType},#{content})")
    int insertInfor(InforBean inforBean);

    @Delete("DELETE FROM infor WHERE id =#{id}")
    int delectInfor(TestInfor testInfor);


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
                                 @Param("pageEnd") int pageEnd);


    @Select("select * from welfare where order by welfare_id  asc LIMIT #{pageStart},#{pageEnd}")
    List<WelfareBean> findAllWelfare(@Param("pageStart") int pageStart,
                                     @Param("pageEnd") int pageEnd);

    @Select("select * from joke where order by joke_id  asc LIMIT #{pageStart},#{pageEnd}")
    List<JokeBean> findAllJoke(@Param("pageStart") int pageStart,
                               @Param("pageEnd") int pageEnd);

    @Select("select * from comment where  infor_id=#{id} order by com_id  asc LIMIT #{pageStart},#{pageEnd}")
    List<CommentBean> findCommAll(@Param("id") int id,
                                  @Param("pageStart") int pageStart,
                                  @Param("pageEnd") int pageEnd);

    @Select("select * from user where user_id =#{id}")
    UserBean findUser(@Param("id") int id);

    @Select("select * from joke  order by joke_id  asc LIMIT #{pageStart},#{pageEnd}")
    List<JokeBean> findJokeAll(@Param("pageStart") int pageStart,
                               @Param("pageEnd") int pageEnd);

    @Select("select * from jokeCom where  joke_id=#{id} order by jokeCom_id  asc LIMIT #{pageStart},#{pageEnd}")
    List<ComBean> findJokeCommAll(@Param("id") int id,
                                  @Param("pageStart") int pageStart,
                                  @Param("pageEnd") int pageEnd);

    @Select("select*from joke where joke_id =#{id}")
    JokeComBean selectJokeComOne(@Param("id") int id);*/


}
