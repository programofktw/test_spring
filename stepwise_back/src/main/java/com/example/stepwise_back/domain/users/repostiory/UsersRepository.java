package com.example.stepwise_back.domain.users.repostiory;

import com.example.stepwise_back.domain.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Boolean existsUsersByUserId(String userID);

}
