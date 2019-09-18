package com.bbs.dao;

import com.bbs.domain.Zoneapply;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneApply_ManageDao {

    /**
     * 查找未处理的版块
     * @return
     */
    @Select("select * from bbs_zoneapply_table where status=0")
    List<Zoneapply> findAll() throws  Exception;

    /**
     * 改变模块申请处理状态为已处理
     * @param applyZoneId
     */
    @Update("update bbs_zoneapply_table set status=1 where applyZoneId=#{id}")
    void changeStatus(int applyZoneId) throws Exception;

    /**
     * 根据applyZoneId查找
     * @param applyZoneId
     * @return
     * @throws Exception
     */
    @Select("select * from bbs_zoneapply_table where applyZoneId=#{id}")
    Zoneapply findById(int applyZoneId) throws Exception;
}
