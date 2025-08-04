package com.example.stepwise_back.domain.post.service.input;

import com.example.stepwise_back.domain.post.controller.dto.request.DeletePostRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class DeletePostInput {
    private final Long postId;

    private final String password;

    public DeletePostInput(Long postId, DeletePostRequest deletePostRequest){
        this.postId = postId;
        this.password = deletePostRequest.getPassword();
    }
}
