package com.bbs.dao;

import com.bbs.domain.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommentsDao {


    @Insert("insert into bbs_comment_table (commentContent,commentTime,commentUserName,articleId) values (#{commentContent},#{commentTime},#{commentUserName},#{articleId})")
    void saveComment(Comment comment);

    @Select("select * from bbs_comment_table where commentUserName =#{commentUserName}")
    List<Comment> getCommentId(String commentUserName);

    @Select("select count(*) from bbs_comment_table where articleId = #{articleId}")
    Integer selectAllCommentsByarticleId(String articleId);


    @Update("update bbs_article_table set replyCount = #{replyCount}  where articleId = #{articleId}")
    void changeReplyComment(@Param("replyCount") Integer replyCount,@Param("articleId") String articleId);


}
