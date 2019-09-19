package com.bbs.dao;


import com.bbs.domain.Zone;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZoneDao {


    @Select("select * from bbs_zone_table")
    List<Zone> findAllZone();
}
