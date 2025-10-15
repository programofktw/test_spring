package com.example.stepwise_back.domain.users.policy;


import lombok.Value;
import org.springframework.stereotype.Component;

import org.springframework.security.crypto.bcrypt.BCrypt;


@Component
public class PasswordEncoder {

    public  String encored(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // 비밀번호 검증
    public  boolean matches(String rawPassword, String hashedPassword) {
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }
}
