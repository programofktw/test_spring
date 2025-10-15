package com.example.stepwise_back.domain.users.service.dto.input;

import com.example.stepwise_back.domain.users.controller.dto.requeset.UserRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserRegisterInput{
    private final String userId;
    private final String password;
    private final String nickname;

    public UserRegisterInput(UserRegisterRequest userRegisterRequest){
        this.userId = userRegisterRequest.getUserId();
        this.password = userRegisterRequest.getPassword();
        this.nickname = userRegisterRequest.getNickname();
    }
}
