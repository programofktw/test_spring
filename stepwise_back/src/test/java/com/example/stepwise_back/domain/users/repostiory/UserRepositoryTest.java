package com.example.stepwise_back.domain.users.repostiory;

import com.example.stepwise_back.domain.users.entity.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    @DisplayName("존재하는 userId로 User를 검색했을 때, 정상적으로 검색되는 지 여부 확인")
    void findUserbyUserIdTest(){
        //Given
        Users newUser = Users.builder()
                .userId("123")
                .nickName("김태완")
                .password("1234")
                .build();

        userRepository.save(newUser);

        //When

        //Then
    }
}