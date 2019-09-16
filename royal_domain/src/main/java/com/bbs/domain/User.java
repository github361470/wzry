package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * bbs_user_table
 * @author 
 */
public class User implements Serializable {
    /**
     * 用户ID
     */
    private Integer userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String userpass;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String picurl;

    /**
     * 1代表普通用户；2代表高级用户，3代表超级管理员
     */
    private Integer role;

    /**
     * 最后登录时间
     */
    private Date lastlogintime;

    /**
     * 登录状态，0代表未登录，1代表已登录
     */
    private Integer loginstatus;

    /**
     * 发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言
     */
    private Integer talkstatus;

    /**
     * 申请升级(0-未申请,1-已申请)
     */
    private Integer isupdating;

    /**
     * 申请升级审核状态(0-未处理,1-已处理)
     */
    private Integer updatestatus;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public Integer getLoginstatus() {
        return loginstatus;
    }

    public void setLoginstatus(Integer loginstatus) {
        this.loginstatus = loginstatus;
    }

    public Integer getTalkstatus() {
        return talkstatus;
    }

    public void setTalkstatus(Integer talkstatus) {
        this.talkstatus = talkstatus;
    }

    public Integer getIsupdating() {
        return isupdating;
    }

    public void setIsupdating(Integer isupdating) {
        this.isupdating = isupdating;
    }

    public Integer getUpdatestatus() {
        return updatestatus;
    }

    public void setUpdatestatus(Integer updatestatus) {
        this.updatestatus = updatestatus;
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
        User other = (User) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getUserpass() == null ? other.getUserpass() == null : this.getUserpass().equals(other.getUserpass()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPicurl() == null ? other.getPicurl() == null : this.getPicurl().equals(other.getPicurl()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getLastlogintime() == null ? other.getLastlogintime() == null : this.getLastlogintime().equals(other.getLastlogintime()))
            && (this.getLoginstatus() == null ? other.getLoginstatus() == null : this.getLoginstatus().equals(other.getLoginstatus()))
            && (this.getTalkstatus() == null ? other.getTalkstatus() == null : this.getTalkstatus().equals(other.getTalkstatus()))
            && (this.getIsupdating() == null ? other.getIsupdating() == null : this.getIsupdating().equals(other.getIsupdating()))
            && (this.getUpdatestatus() == null ? other.getUpdatestatus() == null : this.getUpdatestatus().equals(other.getUpdatestatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getUserpass() == null) ? 0 : getUserpass().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPicurl() == null) ? 0 : getPicurl().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getLastlogintime() == null) ? 0 : getLastlogintime().hashCode());
        result = prime * result + ((getLoginstatus() == null) ? 0 : getLoginstatus().hashCode());
        result = prime * result + ((getTalkstatus() == null) ? 0 : getTalkstatus().hashCode());
        result = prime * result + ((getIsupdating() == null) ? 0 : getIsupdating().hashCode());
        result = prime * result + ((getUpdatestatus() == null) ? 0 : getUpdatestatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", username=").append(username);
        sb.append(", userpass=").append(userpass);
        sb.append(", email=").append(email);
        sb.append(", picurl=").append(picurl);
        sb.append(", role=").append(role);
        sb.append(", lastlogintime=").append(lastlogintime);
        sb.append(", loginstatus=").append(loginstatus);
        sb.append(", talkstatus=").append(talkstatus);
        sb.append(", isupdating=").append(isupdating);
        sb.append(", updatestatus=").append(updatestatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}