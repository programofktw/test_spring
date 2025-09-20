package com.example.stepwise_back.domain.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ResponseDTO<T>{
        @JsonProperty("success")
        private Boolean isSuccess;

        @JsonProperty("stateCode")
        private Integer stateCode;

        @JsonProperty("result")
        private T result;


        public static <T> ResponseDTO<T> of(Boolean isSuccess, Integer stateCode, T result) {
                return ResponseDTO.<T>builder()
                        .isSuccess(isSuccess)
                        .stateCode(stateCode)
                        .result(result)
                        .build();
        }
}
