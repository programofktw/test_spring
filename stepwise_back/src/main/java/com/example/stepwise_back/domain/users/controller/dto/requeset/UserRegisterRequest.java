package com.example.stepwise_back.domain.users.controller.dto.requeset;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRegisterRequest {
    private final String userId;
    private final String password;
    private final String nickname;
}
