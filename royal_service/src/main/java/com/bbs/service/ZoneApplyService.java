package com.bbs.service;

import com.bbs.common.ResponseResult;
import com.bbs.domain.Zoneapply;

import java.util.List;

public interface ZoneApplyService {
    ResponseResult requestNewSection(Zoneapply zoneapply);

    List<Zoneapply> findAllZoneapplyByUserName(String userName);
}
