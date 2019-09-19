package com.bbs.dao;

import com.bbs.domain.Zoneapply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZoneApplyDao {

    @Insert("insert into bbs_zoneapply_table(zoneName,userName,reason) values(#{zoneName},#{userName},#{reason})")
    void requestNewSection(Zoneapply zoneapply) throws Exception;

    @Select("select * from bbs_zoneapply_table where userName = #{userName}")
    List<Zoneapply> findAllZoneapplyByUserName(String userName);
}
