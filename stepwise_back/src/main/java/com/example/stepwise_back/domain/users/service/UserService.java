package com.example.stepwise_back.domain.users.service;

import com.example.stepwise_back.domain.base.NullResponse;
import com.example.stepwise_back.domain.users.service.dto.input.*;
import com.example.stepwise_back.domain.users.service.dto.output.*;

public interface UserService {

    public UserRegisterOutput register(UserRegisterInput userRegisterInput);

    public UserPasswordUpdateOutput updatePassword(UserNicknameUpdateInput userNicknameUpdateInput);

    public UserNicknameUpdateOutput updateNickname(UserNicknameUpdateInput userNicknameUpdateInput);

    public UserDeleteOutput deleteUser(UserDeleteInput userDeleteInput);

    public UserLoginOutput login(UserLoginInput userLoginInput);

    public void validateNicknameUniqueness(String nickname);

    public void validateUserIdUniqueness(String userId);
}
