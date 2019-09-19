package com.bbs.dao;

import com.bbs.domain.Reply;
import org.apache.ibatis.annotations.Insert;

public interface ReplysDao {



    @Insert("insert into bbs_reply_table (replyContent,replyTime,replyUserName,commentId) values (#{replyContent},#{replyTime},#{replyUserName},#{commentId})")
    void saveReply(Reply reply);
}
