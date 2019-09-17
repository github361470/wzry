package com.bbs.domain;

import java.util.Date;

/**
 * 评论信息实体类
 */
public class Comment {
    private int commentId;//评论编号
    private String commentContent;//评论内容
    private Date commentTime;//评论时间
    private String commentUserName;//评论人
    private int commentStatus;//评论状态，1代表屏蔽，0代表解除
    private Article article;//帖子编号,一条评论对应一篇帖子

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public int getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(int commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
