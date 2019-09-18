package com.bbs.service;

public interface UpvoteService {
    void changeUpvote(String upvoteUserName , String articleId );

    void deleteUpvote(String upvoteUserName, String articleId);
}
