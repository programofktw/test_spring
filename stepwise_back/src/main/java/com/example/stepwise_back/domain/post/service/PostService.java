package com.example.stepwise_back.domain.post.service;

import com.example.stepwise_back.domain.post.controller.dto.response.PostDetail;
import com.example.stepwise_back.domain.post.service.input.CreatePostInput;
import com.example.stepwise_back.domain.post.controller.dto.response.PagePost;
import com.example.stepwise_back.domain.post.service.input.DeletePostInput;
import com.example.stepwise_back.domain.post.service.input.SearchPostInput;
import com.example.stepwise_back.domain.post.service.input.UpdatePostInput;
import org.hibernate.query.Page;

import java.util.List;

public interface PostService {
    PagePost getPosts(int page, int size);

    Long createPost(CreatePostInput createPostInput);

    Long deletePost(DeletePostInput deletePostInput) throws Exception;

    PagePost searchPost(SearchPostInput searchPostInput);

    Long updatePost(UpdatePostInput updatePostInput) throws Exception;

    PostDetail getPostDetail(Long id);
}
