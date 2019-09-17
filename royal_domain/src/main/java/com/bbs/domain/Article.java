package com.bbs.domain;

import javafx.scene.text.Text;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 帖子实体类
 */
public class Article {

    private Integer articleId;   //帖子id
    private String title;       //标题
    private String content;    //内容
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date sendTime;     //发送时间
    private String senderName;  //发送人
    private Integer isTop;      // 是否置顶，如果是0，代表不置顶；如果是1，代表置顶
    private String isTopStr;     //置顶状态描述
    private Integer replyCount;   //评论数
    private Integer upvoteCount;  //点赞数
    private Integer browseCount;  //浏览数
    private Zone zone;      //所在交流区
    private Integer isReport;    //举报状态

    public String getIsTopStr() {
        if (isTop==0){
            isTopStr="否";
        }else if (isTop==1){
            isTopStr="是";
        }
        return isTopStr;
    }

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



    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
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

    public void setIsTopStr(String isTopStr) {
        this.isTopStr = isTopStr;
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

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
        this.isReport = isReport;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                ", senderName='" + senderName + '\'' +
                ", isTop=" + isTop +
                ", isTopStr='" + isTopStr + '\'' +
                ", replyCount=" + replyCount +
                ", upvoteCount=" + upvoteCount +
                ", browseCount=" + browseCount +
                ", zone=" + zone +
                ", isReport=" + isReport +
                '}';
    }
}
