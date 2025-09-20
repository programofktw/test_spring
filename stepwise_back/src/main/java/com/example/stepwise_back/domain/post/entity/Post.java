package com.example.stepwise_back.domain.post.entity;

import com.example.stepwise_back.domain.base.BaseEntity;
import com.example.stepwise_back.domain.users.entity.Users;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "title")
    private String title;

    @Builder
    public Post(String userName, String password, String title, String body) {
        this.userName = userName;
        this.password = password;
        this.title = title;
        this.body = body;
    }

    @Column(name = "body")
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // Users 테이블의 PK를 참조하는 외래키
    private Users user;

    public void initPost(Users user){
        this.user = user;
    }

    public void update(String body, String title){
        this.title = title;
        this.body = body;
    }

}
