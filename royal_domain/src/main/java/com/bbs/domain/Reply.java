package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {

    /**
     * replyId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '回复编号',
     *   `replyContent` VARCHAR(255) NOT NULL COMMENT '回复内容',
     *   `replyTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '回复时间',
     *   `replyUserName` VARCHAR(255) NOT NULL COMMENT '回复人',
     *   `commentId` INT(11) DEFAULT NULL COMMENT '评论编号',
     */

    private Integer replyId;//回复编号
    private String replyContent;//回复内容
    private Date replyTime;//回复时间
    private String replyTimeStr;//回复时间字符串形式
    private String replyUserName;//回复人
    private Integer commentId;//评论编号


    //需要获取回复用户的头像，关联user表
    private User user;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyTimeStr() {
        if (replyTime != null) {
            replyTimeStr = DateUtils.date2String(replyTime, "yyyy-MM-dd HH:mm:ss");
        }
        return replyTimeStr;
    }

    public void setReplyTimeStr(String replyTimeStr) {
        this.replyTimeStr = replyTimeStr;
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyContent='" + replyContent + '\'' +
                ", replyTime=" + replyTime +
                ", replyTimeStr='" + replyTimeStr + '\'' +
                ", replyUserName='" + replyUserName + '\'' +
                ", commentId=" + commentId +
                ", user=" + user +
                '}';
    }
}
