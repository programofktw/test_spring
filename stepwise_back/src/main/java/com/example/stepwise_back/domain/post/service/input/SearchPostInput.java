package com.example.stepwise_back.domain.post.service.input;

import com.example.stepwise_back.domain.post.controller.dto.request.SearchPostRequest;
import lombok.Getter;

@Getter
public class SearchPostInput {
    private final String keyword;
    private final Integer category;

    public SearchPostInput(SearchPostRequest searchPostRequest){
        this.keyword = searchPostRequest.getKeyword();
        this.category = searchPostRequest.getCategory();
    }
}
