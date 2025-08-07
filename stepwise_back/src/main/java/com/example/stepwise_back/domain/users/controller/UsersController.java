package com.example.stepwise_back.domain.users.controller;

import com.example.stepwise_back.domain.base.AvailableResponse;
import com.example.stepwise_back.domain.base.NullResponse;
import com.example.stepwise_back.domain.base.ResponseDTO;
import com.example.stepwise_back.domain.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping("/check-id")
    public ResponseEntity<ResponseDTO<AvailableResponse>> isUserIdDuplicated(@RequestParam("userId") String userId){

        return ResponseEntity.ok().body(ResponseDTO.<AvailableResponse>builder()
                .isSuccess(true)
                .stateCode(200)
                .result(AvailableResponse.builder().available(userService.validateUserIdUniqueness(userId)).build()).build());
    }
}
