package com.example.stepwise_back.domain.post.controller.dto.response;

import com.example.stepwise_back.domain.post.entity.Post;

import java.time.LocalDateTime;

public class PostDetail {
    private final Long id;

    private final String title;

    private final String userName;

    private final String body;

    private final LocalDateTime createAt;

    private final LocalDateTime updateAt;


    public PostDetail(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.userName = post.getUserName();
        this.body = post.getBody();
        this.createAt = post.getCreatedAt();
        this.updateAt = post.getUpdatedAt();

    }
}
