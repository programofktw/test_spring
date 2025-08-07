package com.example.stepwise_back.domain.users.service;

import com.example.stepwise_back.domain.users.service.dto.output.UserLoginOutput;

public interface UserService {

    public void register();

    public void updatePassword();

    public void updateNickname();

    public void deleteUser();

    public UserLoginOutput login();
}
