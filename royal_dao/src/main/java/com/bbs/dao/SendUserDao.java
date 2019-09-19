package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Select;

public interface SendUserDao {

    @Select("select * from bbs_user_table where userName= #{senderName}")
    User findUserBySendName(String senderName);


}
