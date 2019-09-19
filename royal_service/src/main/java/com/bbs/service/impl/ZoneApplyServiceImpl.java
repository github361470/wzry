package com.bbs.service.impl;


import com.bbs.common.CommonCode;
import com.bbs.common.ResponseResult;
import com.bbs.dao.ZoneApplyDao;
import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneApplyServiceImpl implements ZoneApplyService {
    @Autowired
    ZoneApplyDao zoneApplyDao;
    @Override
    public ResponseResult requestNewSection(Zoneapply zoneapply) {
        try {
            zoneApplyDao.requestNewSection(zoneapply);
            return new ResponseResult(CommonCode.SUCCESS);
        } catch (Exception e) {
            return new ResponseResult(CommonCode.FAIL);
        }
    }

    @Override
    public List<Zoneapply> findAllZoneapplyByUserName(String userName) {
        return zoneApplyDao.findAllZoneapplyByUserName(userName);
    }
}
