package com.bbs.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UpvoteDao {


    @Insert("insert into bbs_upvote_table (upvoteUserName,upvoteArticleId) values (#{upvoteUserName},#{upvoteArticleId})")
    void changeUpvote(@Param("upvoteUserName") String upvoteUserName, @Param("upvoteArticleId") String upvoteArticleId);


    @Delete("delete from bbs_upvote_table where upvoteUserName = #{upvoteUserName} and upvoteArticleId= #{upvoteArticleId}")
    void deleteUpvote(@Param("upvoteUserName") String upvoteUserName, @Param("upvoteArticleId") String upvoteArticleId);
}
