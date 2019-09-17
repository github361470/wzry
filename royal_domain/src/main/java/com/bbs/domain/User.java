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
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPass;

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
    private Date lastLoginTime;

    /**
     * 登录状态，0代表未登录，1代表已登录
     */
    private Integer loginsStatus;

    /**
     * 发言状态，0代表未屏蔽发言（默认），1代表已屏蔽发言
     */
    private Integer talkStatus;

    /**
     * 申请升级(0-未申请,1-已申请)
     */
    private Integer isupdating;

    /**
     * 申请升级审核状态(0-未处理,1-已处理)
     */
    private Integer updateStatus;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
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

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginsStatus() {
        return loginsStatus;
    }

    public void setLoginsStatus(Integer loginsStatus) {
        this.loginsStatus = loginsStatus;
    }

    public Integer getTalkStatus() {
        return talkStatus;
    }

    public void setTalkStatus(Integer talkStatus) {
        this.talkStatus = talkStatus;
    }

    public Integer getIsupdating() {
        return isupdating;
    }

    public void setIsupdating(Integer isupdating) {
        this.isupdating = isupdating;
    }

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", email='" + email + '\'' +
                ", picurl='" + picurl + '\'' +
                ", role=" + role +
                ", lastLoginTime=" + lastLoginTime +
                ", loginsStatus=" + loginsStatus +
                ", talkStatus=" + talkStatus +
                ", isupdating=" + isupdating +
                ", updateStatus=" + updateStatus +
                '}';
    }
}