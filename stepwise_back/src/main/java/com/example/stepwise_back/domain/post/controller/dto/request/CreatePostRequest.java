package com.example.stepwise_back.domain.post.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreatePostRequest {
    private final String userName;

    private final String password;

    private final String title;

    private final String body;
}
