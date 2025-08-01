package com.example.stepwise_back.domain.post.service.input;

import com.example.stepwise_back.domain.post.controller.dto.request.CreatePostRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreatePostInput {
    private final String userName;

    private final String password;

    private final String title;

    private final String body;

    public CreatePostInput(CreatePostRequest createPostRequest){
        this.userName = createPostRequest.getUserName();
        this.password = createPostRequest.getPassword();
        this.title = createPostRequest.getTitle();
        this.body = createPostRequest.getBody();
    }
}
