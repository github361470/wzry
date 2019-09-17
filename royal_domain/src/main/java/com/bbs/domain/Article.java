package com.bbs.domain;

import com.bbs.utils.DateUtils;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {

    /*`
    articleId` INT(11) NOT NULL AUTO_INCREMENT COMMENT '帖子编号',title` VARCHAR(500) DEFAULT NULL COMMENT '标题',
  `content` TEXT NOT NULL COMMENT '内容',
  `sendTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发送时间',
  `senderName` VARCHAR(255) NOT NULL COMMENT '发送人编号',
  `isTop` INT(11) NOT NULL DEFAULT '0' COMMENT '是否置顶，',
  `replyCount` INT(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `upvoteCount` INT(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `browseCount` INT(11) NOT NULL DEFAULT '0' COMMENT '浏览数',
  `zoneId` INT(11) NOT NULL COMMENT '所在交流区',
  `isReport` INT(2) DEFAULT '0' COMMENT '举报状态',*/

    private Integer articleId;//帖子编号
    private String title;
    private String content;//内容
    private Date sendTime;//发送时间
    private String sendTimeStr;//发送时间字符串格式
    private String senderName;//发送人编号
    private Integer isTop;//是否置顶 如果是0，代表不置顶；如果是1，代表置顶；
    private Integer replyCount;//评论数
    private Integer upvoteCount;//点赞数
    private Integer browseCount;//浏览数
    private Integer zoneId;//所在交流区
    private Integer isReport;//举报状态


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSendTimeStr() {
        if (sendTime!=null) {
            sendTimeStr = DateUtils.date2String(sendTime,"yyyy-MM-dd HH:mm:ss");
        }
        return sendTimeStr;
    }

    public void setSendTimeStr(String sendTimeStr) {
        this.sendTimeStr = sendTimeStr;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getUpvoteCount() {
        return upvoteCount;
    }

    public void setUpvoteCount(Integer upvoteCount) {
        this.upvoteCount = upvoteCount;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
        this.isReport = isReport;
    }
}
