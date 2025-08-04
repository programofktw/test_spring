package com.example.stepwise_back.domain.post.service;

import com.example.stepwise_back.domain.post.controller.dto.response.PagePost;
import com.example.stepwise_back.domain.post.controller.dto.response.PostDetail;
import com.example.stepwise_back.domain.post.entity.Post;
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
import java.util.NoSuchElementException;


//ver.1 비로그인 익명 게시판 2025.08.04
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
        Post newPost = Post.builder()
                        .userName(createPostInput.getUserName())
                        .password(createPostInput.getPassword())
                        .body(createPostInput.getBody())
                        .title(createPostInput.getTitle())
                        .build();

        return postRepository.save(newPost).getId();
    }

    @Override
    public Long deletePost(DeletePostInput deletePostInput) throws Exception {
        Post existPost = postRepository.findById(deletePostInput.getPostId())
                .orElseThrow(() -> new Exception("존재하지 않는 게시글"));


        if(!existPost.getPassword().equals(deletePostInput.getPassword())){
            throw new Exception("");
        }

        postRepository.delete(existPost);

        return existPost.getId();
    }


    
    @Override
    public PagePost searchPost(SearchPostInput searchPostInput) {

        Pageable pageable = PageRequest.of(searchPostInput.getPage(), 10, Sort.by("createdAt").descending());

        return new PagePost(postRepository.findAllByTitle(searchPostInput.getKeyword(),pageable));
    }

    @Override
    public Long updatePost(UpdatePostInput updatePostInput) throws Exception {
        Post post = postRepository.findById(updatePostInput.getPostId())
                .orElseThrow(() -> new Exception("존재하지 않는 게시글입니다."));

        if (!post.getPassword().equals(updatePostInput.getPassword())) {
            throw new Exception("비밀번호가 일치하지 않습니다.");
        }

        post.update(updatePostInput.getTitle(), updatePostInput.getBody());

        return post.getId();
    }
    @Override
    public PostDetail getPostDetail(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));
        return new PostDetail(post);
    }
}
