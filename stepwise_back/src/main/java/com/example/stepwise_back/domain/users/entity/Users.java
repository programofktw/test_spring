package com.example.stepwise_back.domain.users.entity;

import com.example.stepwise_back.domain.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA용 기본 생성자
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users extends BaseEntity {

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    public void updateNickName(String nickName){
        this.nickName = nickName;
    }

    public void updatePassword(String password){
        this.password = password;
    }

}
