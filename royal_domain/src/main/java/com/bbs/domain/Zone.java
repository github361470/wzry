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

    private static final long serialVersionUID = 1L;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

   /* @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Zone other = (Zone) that;
        return (this.getZoneid() == null ? other.getZoneid() == null : this.getZoneid().equals(other.getZoneid()))
            && (this.getZonename() == null ? other.getZonename() == null : this.getZonename().equals(other.getZonename()))
            && (this.getIsdef() == null ? other.getIsdef() == null : this.getIsdef().equals(other.getIsdef()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getZoneid() == null) ? 0 : getZoneid().hashCode());
        result = prime * result + ((getZonename() == null) ? 0 : getZonename().hashCode());
        result = prime * result + ((getIsdef() == null) ? 0 : getIsdef().hashCode());
        return result;
    }
*/
   /* @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", zoneid=").append(zoneid);
        sb.append(", zonename=").append(zonename);
        sb.append(", isdef=").append(isdef);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }*/
}