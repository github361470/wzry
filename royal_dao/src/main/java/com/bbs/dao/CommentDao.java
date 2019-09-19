package com.bbs.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



public interface CommentDao {

    @Select("SELECT count(*) from bbs_comment_table WHERE commentUserName=#{userName}")
    Integer queryCommentCountByUserName(String userName);
}
