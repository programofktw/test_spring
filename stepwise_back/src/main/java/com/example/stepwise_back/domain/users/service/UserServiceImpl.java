package com.example.stepwise_back.domain.users.service;

import com.example.stepwise_back.domain.users.entity.Users;
import com.example.stepwise_back.domain.users.policy.PasswordEncoder;
import com.example.stepwise_back.domain.users.repostiory.UserRepository;
import com.example.stepwise_back.domain.users.service.dto.input.UserDeleteInput;
import com.example.stepwise_back.domain.users.service.dto.input.UserLoginInput;
import com.example.stepwise_back.domain.users.service.dto.input.UserNicknameUpdateInput;
import com.example.stepwise_back.domain.users.service.dto.input.UserRegisterInput;
import com.example.stepwise_back.domain.users.service.dto.output.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jmx.ParentAwareNamingStrategy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public UserRegisterOutput register(UserRegisterInput userRegisterInput) {

        //닉네임 중복은 허용합니다.
        if( userRepository.existsUsersByUserId(userRegisterInput.getUserId())){
            throw new IllegalArgumentException("이미 존재하는 UserId입니다.");
        }

        Users user = Users.builder()
                .userId(userRegisterInput.getUserId())
                .password(passwordEncoder.encored(userRegisterInput.getPassword()))
                .nickName(userRegisterInput.getNickname())
                .build();

        userRepository.save(user);

        return new UserRegisterOutput(true);
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
        return !userRepository.existsUsersByUserId(userId);
    }
}
