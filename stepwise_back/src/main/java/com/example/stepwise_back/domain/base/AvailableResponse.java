package com.example.stepwise_back.domain.base;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AvailableResponse {
    private Boolean available;
}
