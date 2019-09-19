package com.bbs.dao;


import com.bbs.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from bbs_user_table")
    List<User> findAll();
    @Select("select * from bbs_user_table where userName=#{userName}")
    User findByUserName(String username);
    @Insert("insert into bbs_user_table(userName,userPass,email,picUrl,loginStatus) values(#{userName},#{userPass},#{email},#{picUrl},#{loginStatus})")
    void userRegister(User user)throws Exception;

    @Select("select * from bbs_user_table where userName=#{userName} and userPass=#{userPass}")
    User login(@Param("userName") String userName, @Param("userPass") String userPass);
    @Update("update bbs_user_table set username=#{userName},userPass=#{userPass},email=#{email},picUrl=#{picUrl},role=#{role}," +
            "lastLoginTime=#{lastLoginTime},loginStatus=#{loginStatus},talkStatus=#{talkStatus}," +
            "isupdating=#{isupdating},updateStatus=#{updateStatus} where userId=#{userId}")
    void update(User user);
}
