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

    public Integer getApplyzoneid() {
        return applyZoneId;
    }

    public void setApplyzoneid(Integer applyzoneid) {
        this.applyZoneId = applyzoneid;
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

    @Override
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
        Zoneapply other = (Zoneapply) that;
        return (this.getApplyzoneid() == null ? other.getApplyzoneid() == null : this.getApplyzoneid().equals(other.getApplyzoneid()))
            && (this.getZoneName() == null ? other.getZoneName() == null : this.getZoneName().equals(other.getZoneName()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApplyzoneid() == null) ? 0 : getApplyzoneid().hashCode());
        result = prime * result + ((getZoneName() == null) ? 0 : getZoneName().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", applyzoneid=").append(applyZoneId);
        sb.append(", zoneName=").append(zoneName);
        sb.append(", userName=").append(userName);
        sb.append(", reason=").append(reason);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}