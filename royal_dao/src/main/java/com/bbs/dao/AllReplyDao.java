package com.bbs.dao;

import com.bbs.domain.Reply;
import com.bbs.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AllReplyDao {

    @Select("select * from bbs_reply_table where commentId = #{commentId}")
    @Results({
            @Result(id = true,property = "replyId",column = "replyId"),
            @Result(property = "replyContent",column = "replyContent"),
            @Result(property = "replyTime",column = "replyTime"),
            @Result(property = "replyUserName",column = "replyUserName"),
            @Result(property = "commentId",column = "commentId"),
            @Result(property = "user",column = "replyUserName",javaType = User.class,one = @One(select = "com.bbs.dao.ReplyUserDao.findUserByName")),
    })
    List<Reply> findAllReplyByCommentId(String commentId);
}
