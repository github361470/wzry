package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Select;

public interface CommentUserDao {


    @Select("select * from bbs_user_table where userName= #{userName}")
    User findUserByName(String userName);
}
