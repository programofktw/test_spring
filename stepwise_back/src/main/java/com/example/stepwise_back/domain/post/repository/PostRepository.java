package com.example.stepwise_back.domain.post.repository;

import com.example.stepwise_back.domain.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findAllByTitle(String title, Pageable pageable);
}
