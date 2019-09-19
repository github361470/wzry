package com.bbs.dao;

import com.bbs.domain.Comment;
import com.bbs.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AllCommentsDao {

    @Select("select * from bbs_comment_table where articleId =#{articleId}")
    @Results({
            @Result(id = true,property = "commentId",column = "commentId"),
            @Result(property = "commentContent",column = "commentContent"),
            @Result(property = "commentTime",column = "commentTime"),
            @Result(property = "commentUserName",column = "commentUserName"),
            @Result(property = "commentStatus",column = "commentStatus"),
            @Result(property = "articleId",column = "articleId"),
            @Result(property = "user",column = "commentUserName",javaType = User.class,one = @One(select = "com.bbs.dao.CommentUserDao.findUserByName")),
            @Result(property = "replies",column = "commentId",javaType = List.class,many=@Many(select = "com.bbs.dao.AllReplyDao.findAllReplyByCommentId")),



    })
    List<Comment> findbyArticleId(String articleId);


    /**
     * 获取到帖子楼主的信息
     * @param senderName
     * @return
     */
    @Select("select * from bbs_user_table where userName = #{senderName}")
     User findbySenderName(String senderName);
}
