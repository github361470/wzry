package com.bbs.service;

import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;

import java.util.List;

public interface ZoneApply_ManageService {
    List<Zoneapply> findByPage(int page,int size) throws Exception;
    void changeStatus(int applyZoneId) throws Exception;
    void passZone(int applyZoneId) throws Exception;
    List<Zone> findAllZone() throws Exception;
}
