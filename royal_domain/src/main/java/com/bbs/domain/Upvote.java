package com.bbs.domain;

import java.io.Serializable;

/**
 * bbs_upvote_table
 * @author 
 */
public class Upvote implements Serializable{
    /**
     * 点赞人
     */
    private String upvoteusername;

    /**
     * 点赞帖子
     */
    private Integer upvotearticleid;

    private Integer isupvote;

    private static final long serialVersionUID = 1L;


    public String getUpvoteusername() {
        return upvoteusername;
    }

    public void setUpvoteusername(String upvoteusername) {
        this.upvoteusername = upvoteusername;
    }

    public Integer getUpvotearticleid() {
        return upvotearticleid;
    }

    public void setUpvotearticleid(Integer upvotearticleid) {
        this.upvotearticleid = upvotearticleid;
    }

    public Integer getIsupvote() {
        return isupvote;
    }

    public void setIsupvote(Integer isupvote) {
        this.isupvote = isupvote;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "BbsUpvoteTableKey{" +
                "upvoteusername='" + upvoteusername + '\'' +
                ", upvotearticleid=" + upvotearticleid +
                ", isupvote=" + isupvote +
                '}';
    }

}