package com.bbs.domain;

import java.io.Serializable;

/**
 * bbs_zoneapply_table
 * @author 
 */
public class Zoneapply implements Serializable {
    private Integer applyZoneId;

    /**
     * 新增板块名字
     */
    private String zoneName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 申请原因
     */
    private String reason;

    /**
     * 处理状态(未处理-0,已处理-1)
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getApplyZoneId() {
        return applyZoneId;
    }

    public void setApplyZoneId(Integer applyZoneId) {
        this.applyZoneId = applyZoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}