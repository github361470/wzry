package com.bbs.service.impl;

import com.bbs.dao.ZoneApply_ManageDao;
import com.bbs.dao.Zone_ManageDao;
import com.bbs.domain.Zone;
import com.bbs.domain.Zoneapply;
import com.bbs.service.ZoneApply_ManageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ZoneApply_ManageServiceImpl implements ZoneApply_ManageService {

    @Autowired
    private ZoneApply_ManageDao zoneApply_manageDao;
    @Autowired
    private Zone_ManageDao zone_manageDao;
    /**
     * 查找未申请模块信息
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @Override
    public List<Zoneapply> findByPage(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return zoneApply_manageDao.findAll();
    }

    /**
     * 改变模块申请处理状态
     * @param applyZoneId
     * @throws Exception
     */
    @Override
    public void changeStatus(int applyZoneId) throws Exception {
        zoneApply_manageDao.changeStatus(applyZoneId);
    }

    /**
     * 通过版块申请
     * @param applyZoneId
     * @throws Exception
     */
    @Override
    public void passZone(int applyZoneId) throws Exception {
        Zoneapply zoneApply = zoneApply_manageDao.findById(applyZoneId);
        zoneApply_manageDao.changeStatus(applyZoneId);
        zone_manageDao.save(zoneApply);
    }

    @Override
    public List<Zone> findAllZone() throws Exception {
        return zone_manageDao.findAll();
    }
}
