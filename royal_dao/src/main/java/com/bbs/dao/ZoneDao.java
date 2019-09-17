package com.bbs.dao;

import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneDao {
    @Select("select * from bbs_zone_table where zoneId=#{id}")
    Zone findById(int id);
}
