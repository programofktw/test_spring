package com.example.stepwise_back.domain.post.controller.dto.response;

import com.example.stepwise_back.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PagePost {

    private final int totalPage;

    private final List<PostPreview> postPreviews;

    public PagePost(Page<Post> posts){
        this.totalPage = posts.getTotalPages();

        postPreviews = posts.getContent().stream()
                .map(PostPreview::from)
                .collect(Collectors.toList());
    }

    @Builder
    record PostPreview(Long id, String title, String userName, LocalDateTime createdAt) {
            public static PostPreview from(Post post) {
                return PostPreview.builder()
                        .id(post.getId())
                        .createdAt(post.getCreatedAt())
                        .userName(post.getUserName())
                        .title(post.getTitle())
                        .build();
            }
        }
}
