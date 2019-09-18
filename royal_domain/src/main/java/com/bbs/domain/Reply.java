package com.bbs.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 回复实体类
 */
public class Reply implements Serializable {
    private int replyId;//回复编号
    private String replyContent;//回复内容
    private Date replyTime;//
    private String replyUserName;//回复人
    //private int commentId;//评论人编号
    private Comment comment;//一条回复只能对应一条评论

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
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

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
