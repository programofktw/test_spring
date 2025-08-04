package com.example.stepwise_back.domain.post.service.input;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Builder
public class SearchPostInput {
    private final String keyword;
    private final Integer category;
    private final Integer page;
    private final Integer size;
}
