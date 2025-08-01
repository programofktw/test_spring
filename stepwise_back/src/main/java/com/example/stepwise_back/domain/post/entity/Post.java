package com.example.stepwise_back.domain.post.entity;

import com.example.stepwise_back.domain.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA용 기본 생성자
@AllArgsConstructor
@Builder
@Entity
public class Post extends BaseEntity {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;
}