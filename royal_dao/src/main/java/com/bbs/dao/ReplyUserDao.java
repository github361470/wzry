package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Select;

public interface ReplyUserDao {

    @Select("select * from bbs_user_table where userName= #{replyUserName}")
    User findUserByName(String replyUserName);
}
