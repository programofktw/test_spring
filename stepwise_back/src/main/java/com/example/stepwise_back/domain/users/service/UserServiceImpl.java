package com.example.stepwise_back.domain.users.service;

import com.example.stepwise_back.domain.users.repostiory.UsersRepository;
import com.example.stepwise_back.domain.users.service.dto.input.UserDeleteInput;
import com.example.stepwise_back.domain.users.service.dto.input.UserLoginInput;
import com.example.stepwise_back.domain.users.service.dto.input.UserNicknameUpdateInput;
import com.example.stepwise_back.domain.users.service.dto.input.UserRegisterInput;
import com.example.stepwise_back.domain.users.service.dto.output.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;

    @Override
    public UserRegisterOutput register(UserRegisterInput userRegisterInput) {
        return null;
    }

    @Override
    public UserPasswordUpdateOutput updatePassword(UserNicknameUpdateInput userNicknameUpdateInput) {
        return null;
    }

    @Override
    public UserNicknameUpdateOutput updateNickname(UserNicknameUpdateInput userNicknameUpdateInput) {
        return null;
    }

    @Override
    public UserDeleteOutput deleteUser(UserDeleteInput userDeleteInput) {
        return null;
    }

    @Override
    public UserLoginOutput login(UserLoginInput userLoginInput) {
        return null;
    }

    @Override
    public boolean validateNicknameUniqueness(String nickname) {
        return false;
    }

    @Override
    public boolean validateUserIdUniqueness(String userId) {
        return usersRepository.existsUsersByUserId(userId);
    }
}
