package com.bbs.dao;

import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Zone_ManageDao {
    /**
     * 根据zoneId查找zone
     * @param id
     * @return
     */
    @Select("select * from bbs_zone_table where zoneId=#{id}")
    Zone findById(int id) throws Exception;

    /**
     * 新增版块
     * @param zoneApply
     */
    @Insert("insert into bbs_zone_table(zoneName,isDef) values(#{zoneApply.zoneName},1)")
    void save(@Param("zoneApply") Zoneapply zoneApply) throws Exception;

    @Select("select * from bbs_zone_table")
    List<Zone> findAll();

}
