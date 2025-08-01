package com.example.stepwise_back.domain.post.service;

import com.example.stepwise_back.domain.post.controller.dto.response.PagePost;
import com.example.stepwise_back.domain.post.controller.dto.response.PostDetail;
import com.example.stepwise_back.domain.post.repository.PostRepository;
import com.example.stepwise_back.domain.post.service.input.CreatePostInput;
import com.example.stepwise_back.domain.post.service.input.DeletePostInput;
import com.example.stepwise_back.domain.post.service.input.SearchPostInput;
import com.example.stepwise_back.domain.post.service.input.UpdatePostInput;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public PagePost getPosts(int page, int size) {

        Pageable pageable = PageRequest.of(page, 10, Sort.by("createdAt").descending());
        return new PagePost(postRepository.findAll(pageable));
    }

    @Override
    public Long createPost(CreatePostInput createPostInput) {
        return 0L;
    }

    @Override
    public Long deletePost(DeletePostInput deletePostInput) {
        return 0L;
    }

    @Override
    public List<PagePost> searchPost(SearchPostInput searchPostInput) {
        return List.of();
    }

    @Override
    public Long updatePost(UpdatePostInput updatePostInput) {
        return 0L;
    }

    @Override
    public PostDetail getPostDetail(Long id) {
        return null;
    }
}
