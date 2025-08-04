package com.example.stepwise_back.domain.post.service.input;

import com.example.stepwise_back.domain.post.controller.dto.request.UpdatePostRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdatePostInput {
    private final String password;

    private final Long postId;

    private final String body;

    private final String title;

    @Builder
    public UpdatePostInput(UpdatePostRequest updatePostRequest, Long postId){
        this.password = updatePostRequest.password();
        this.body = updatePostRequest.body();
        this.title = updatePostRequest.title();
        this.postId = postId;
    }
}
