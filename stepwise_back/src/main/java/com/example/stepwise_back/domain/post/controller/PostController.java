package com.example.stepwise_back.domain.post.controller;

import com.example.stepwise_back.domain.base.ResponseDTO;
import com.example.stepwise_back.domain.post.controller.dto.response.PagePost;
import com.example.stepwise_back.domain.post.controller.dto.response.PostDetail;
import com.example.stepwise_back.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("")
    public ResponseEntity<ResponseDTO<PagePost>> getPosts(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size)
    {
        return ResponseEntity.ok().body(
                            ResponseDTO.<PagePost>builder()
                                .isSuccess(true)
                                .stateCode(200)
                                .result(postService.getPosts(page, size))
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
}
