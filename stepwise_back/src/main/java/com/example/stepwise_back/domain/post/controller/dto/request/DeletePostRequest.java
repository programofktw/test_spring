package com.example.stepwise_back.domain.post.controller.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DeletePostRequest {

    private final String password;
}
