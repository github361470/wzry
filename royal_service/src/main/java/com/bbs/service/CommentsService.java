package com.bbs.service;

public interface CommentsService {
    Integer saveComment(String commentContent, String username, String articleId);
}
