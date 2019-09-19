package com.bbs.domain;

import java.io.Serializable;

/**
 * bbs_zone_table
 * @author 
 */
public class Zone implements Serializable {
    /**
     * 交流区编号
     */
    private Integer zoneId;

    /**
     * 交流区名字
     */
    private String zoneName;

    /**
     * 是否默认，1代表默认，2代表非默认
     */
    private Integer isDef;

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Integer getIsDef() {
        return isDef;
    }

    public void setIsDef(Integer isDef) {
        this.isDef = isDef;
    }
}