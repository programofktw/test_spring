package com.example.stepwise_back.domain.users.repostiory;

import com.example.stepwise_back.domain.users.entity.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    @DisplayName("userId가 이미 존재하는 지 검색했을 때, 존재하는 userId에 대해 true 반환하는지 확인.")
    void findUserbyUserIdTest(){
        //Given

        String userId = UUID.randomUUID().toString();

        Users newUser = Users.builder()
                .userId(userId)
                .nickName("김태완")
                .password("1234")
                .build();

        userRepository.save(newUser);

        //When
        boolean isExist = userRepository.existsUsersByUserId(userId);

        //Then
        assertThat(isExist).isEqualTo(true);

    }
}