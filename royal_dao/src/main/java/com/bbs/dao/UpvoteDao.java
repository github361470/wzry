package com.bbs.dao;

import org.apache.ibatis.annotations.*;

public interface UpvoteDao {


    @Insert("insert into bbs_upvote_table (upvoteUserName,upvoteArticleId) values (#{upvoteUserName},#{upvoteArticleId})")
    void changeUpvote(@Param("upvoteUserName") String upvoteUserName, @Param("upvoteArticleId") String upvoteArticleId);


    @Delete("delete from bbs_upvote_table where upvoteUserName = #{upvoteUserName} and upvoteArticleId= #{upvoteArticleId}")
    void deleteUpvote(@Param("upvoteUserName") String upvoteUserName, @Param("upvoteArticleId") String upvoteArticleId);




    @Select("select count(*) from bbs_upvote_table where upvoteArticleId=#{upvoteArticleId}")
    Integer getUpvoteCount(Integer upvoteArticleId);

    @Update("update bbs_article_table set upvoteCount = #{upvoteCount} where articleId=#{articleId}")
    Integer SetUpvoteCount(@Param("upvoteCount") Integer upvoteCount, @Param("articleId") String articleId);



}
