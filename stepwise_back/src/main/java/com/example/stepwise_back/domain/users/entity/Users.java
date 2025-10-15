package com.example.stepwise_back.domain.users.entity;

import com.example.stepwise_back.domain.base.BaseEntity;
import com.example.stepwise_back.domain.post.entity.Post;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA용 기본 생성자
@Entity
@Table(name = "users")
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();


    public void updateNickName(String nickName){
        this.nickName = nickName;
    }

    public void updatePassword(String password){
        this.password = password;
    }


    public void addPost(Post post) {
        posts.add(post);
        post.initPost(this);
    }

    public void removePost(Post post) {
        posts.remove(post);
        post.initPost(null);
    }

    @Builder
    public Users(String userId, String password, String nickName) {
        this.userId = userId;
        this.password = password;
        this.nickName = nickName;
    }
}
