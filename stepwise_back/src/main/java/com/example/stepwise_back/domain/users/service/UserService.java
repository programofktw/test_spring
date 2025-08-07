package com.example.stepwise_back.domain.users.service;

import com.example.stepwise_back.domain.users.service.dto.input.UserDeleteInput;
import com.example.stepwise_back.domain.users.service.dto.input.UserLoginInput;
import com.example.stepwise_back.domain.users.service.dto.output.UserDeleteOutput;
import com.example.stepwise_back.domain.users.service.dto.output.UserLoginOutput;

public interface UserService {

    public void register();

    public void updatePassword();

    public void updateNickname();

    public UserDeleteOutput deleteUser(UserDeleteInput userDeleteInput);

    public UserLoginOutput login(UserLoginInput userLoginInput);
}
