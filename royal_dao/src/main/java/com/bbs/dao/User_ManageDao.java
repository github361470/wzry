package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_ManageDao {

    /**
     * 用户的模糊查询
     * @param user
     * @return
     */
    @Select("<script>\n" +
            "        select * from bbs_user_table \n" +
            "        <where>\n" +
            "            <if test=\"user.userName!=null and user.userName!=''\">\n" +
            "                and userName like concat('%',#{user.userName},'%') \n" +
            "            </if>\n" +
            "            <if test=\"user.role!=0 \">\n" +
            "                and role=#{user.role}\n" +
            "            </if>\n" +
            "        </where>\n" +
            "</script>")
    List<User> findAll(@Param("user") User user) throws Exception;

    /**
     * 根据用户Id查找用户
     * @param userId
     * @return
     */
    @Select("select * from bbs_user_table where userId=#{userId}")
    User findById(int userId) throws Exception;

    /**
     * 修改用户的发言状态
     * @param user
     */
    @Update("update bbs_user_table set talkStatus=#{user.talkStatus} where userId=#{user.userId}")
    void changeTalkStatus(@Param("user") User user) throws Exception;

    @Update("update bbs_user_table set role=2,updateStatus=1 where userId=#{id}")
    void changeGrade(int userId) throws Exception;

    @Select("select * from bbs_user_table where userName=#{username}")
    public User findByUsername(String username) throws Exception;
}
