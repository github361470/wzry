package com.bbs.domain;

import java.io.Serializable;

/**
 * bbs_zoneapply_table
 * @author 
 */
public class Zoneapply implements Serializable {
    private Integer applyzoneid;

    /**
     * 新增板块名字
     */
    private String zonename;

    /**
     * 用户名
     */
    private String username;

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
        return applyzoneid;
    }

    public void setApplyzoneid(Integer applyzoneid) {
        this.applyzoneid = applyzoneid;
    }

    public String getZonename() {
        return zonename;
    }

    public void setZonename(String zonename) {
        this.zonename = zonename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
            && (this.getZonename() == null ? other.getZonename() == null : this.getZonename().equals(other.getZonename()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApplyzoneid() == null) ? 0 : getApplyzoneid().hashCode());
        result = prime * result + ((getZonename() == null) ? 0 : getZonename().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
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
        sb.append(", applyzoneid=").append(applyzoneid);
        sb.append(", zonename=").append(zonename);
        sb.append(", username=").append(username);
        sb.append(", reason=").append(reason);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}