package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from bbs_user_table")
    List<User> findAll();
}
