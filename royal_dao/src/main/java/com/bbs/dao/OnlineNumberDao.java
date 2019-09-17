package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OnlineNumberDao {


    @Select("select * from bbs_user_table where loginStatus = 1")
    List<User> findOnlineUser();
}
