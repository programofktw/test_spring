package com.example.stepwise_back.domain.post.controller;

import com.example.stepwise_back.domain.base.ResponseDTO;
import com.example.stepwise_back.domain.post.controller.dto.request.CreatePostRequest;
import com.example.stepwise_back.domain.post.controller.dto.request.DeletePostRequest;
import com.example.stepwise_back.domain.post.controller.dto.request.UpdatePostRequest;
import com.example.stepwise_back.domain.post.controller.dto.response.PagePost;
import com.example.stepwise_back.domain.post.controller.dto.response.PostDetail;
import com.example.stepwise_back.domain.post.service.PostService;
import com.example.stepwise_back.domain.post.service.input.CreatePostInput;
import com.example.stepwise_back.domain.post.service.input.DeletePostInput;
import com.example.stepwise_back.domain.post.service.input.SearchPostInput;
import com.example.stepwise_back.domain.post.service.input.UpdatePostInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("")
    public ResponseEntity<ResponseDTO<PagePost>> getPosts(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return ResponseEntity.ok().body(
                ResponseDTO.of(true, 200,
                        postService.getPosts(page, size))
        );
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO<PagePost>> searchPosts(
            @RequestParam("category") Integer category,
            @RequestParam("keyword") String keyword,
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
    ) {
        return ResponseEntity.ok().body(
                ResponseDTO.of(true, 200,
                        postService.searchPost(
                                SearchPostInput.builder()
                                        .category(category)
                                        .keyword(keyword)
                                        .page(page)
                                        .size(size)
                                        .build()
                        ))
        );
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<ResponseDTO<PostDetail>> getPostDetail(
            @PathVariable("post_id") Long postId
    ) {
        return ResponseEntity.ok().body(
                ResponseDTO.of(true, 200,
                        postService.getPostDetail(postId))
        );
    }

    @PostMapping("")
    public ResponseEntity<ResponseDTO<Long>> createPost(
            @RequestBody CreatePostRequest createPostRequest
    ) {
        return ResponseEntity.ok().body(
                ResponseDTO.of(true, 200,
                        postService.createPost(new CreatePostInput(createPostRequest)))
        );
    }

    @PutMapping("/{post_id}")
    public ResponseEntity<ResponseDTO<Long>> updatePost(
            @PathVariable("post_id") Long postId,
            @RequestBody UpdatePostRequest updatePostRequest
    ) throws Exception {
        return ResponseEntity.ok().body(
                ResponseDTO.of(true, 200,
                        postService.updatePost(UpdatePostInput.builder()
                                .updatePostRequest(updatePostRequest)
                                .postId(postId)
                                .build()))
        );
    }

    @DeleteMapping("/{post_id}")
    public ResponseEntity<ResponseDTO<Long>> deletePost(
            @PathVariable("post_id") Long postId,
            @RequestBody DeletePostRequest deletePostRequest
    ) throws Exception {
        return ResponseEntity.ok().body(
                ResponseDTO.of(true, 200,
                        postService.deletePost(new DeletePostInput(postId, deletePostRequest)))
        );
    }
}
