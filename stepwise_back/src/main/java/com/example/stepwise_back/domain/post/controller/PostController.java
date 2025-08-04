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
    ){
        return ResponseEntity.ok().body(
                            ResponseDTO.<PagePost>builder()
                                .isSuccess(true)
                                .stateCode(200)
                                .result(postService.getPosts(page, size))
                                .build()
                            );
    }


    @GetMapping("/search")
    public ResponseEntity<ResponseDTO<PagePost>> searchPosts(
            @RequestParam("category") Integer category,
            @RequestParam("keyword") String keyword,
            @RequestParam("size") Integer size,
            @RequestParam("page") Integer page
    ){
        return ResponseEntity.ok().body(
                ResponseDTO.<PagePost>builder()
                        .isSuccess(true)
                        .stateCode(200)
                        .result(postService.searchPost(
                                SearchPostInput.builder()
                                        .category(category)
                                        .keyword(keyword)
                                        .page(page)
                                        .size(size)
                                        .build()
                        ))
                        .build()
        );
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<ResponseDTO<PostDetail>> getPostDetail(
            @PathVariable("post_id") Long postId
    ){

        return ResponseEntity.ok().body(
                    ResponseDTO.<PostDetail>builder()
                            .isSuccess(true)
                            .stateCode(200)
                            .result(postService.getPostDetail(postId))
                            .build()
                    );

    }


    @PostMapping("")
    public ResponseEntity<ResponseDTO<Long>> createPost(
            @RequestBody CreatePostRequest createPostRequest
    ){
        return ResponseEntity.ok().body(
                ResponseDTO.<Long>builder()
                        .isSuccess(true)
                        .stateCode(200)
                        .result(postService.createPost(new CreatePostInput(createPostRequest)))
                        .build()
        );
    }

    @PutMapping("/{post_id}")
    public ResponseEntity<ResponseDTO<Long>> updatePost(
            @PathVariable("post_id") Long postId,
            @RequestBody UpdatePostRequest updatePostRequest
    ) throws Exception {
        return ResponseEntity.ok().body(
                ResponseDTO.<Long>builder()
                        .isSuccess(true)
                        .stateCode(200)
                        .result(postService.updatePost(UpdatePostInput
                                                            .builder()
                                                            .updatePostRequest(updatePostRequest)
                                                            .postId(postId)
                                                            .build()))
                        .build()
        );
    }

    @DeleteMapping("/{post_id}")
    public ResponseEntity<ResponseDTO<Long>> deletePost(
            @PathVariable("post_id") Long postId,
            @RequestBody DeletePostRequest deletePostRequest
    ) throws Exception {
        return ResponseEntity.ok().body(
                ResponseDTO.<Long>builder()
                        .isSuccess(true)
                        .stateCode(200)
                        .result(postService.deletePost(
                                new DeletePostInput(postId, deletePostRequest)
                        ))
                        .build()
        );
    }
}
