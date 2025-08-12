package com.example.stepwise_back.domain.users.controller;

import com.example.stepwise_back.domain.base.AvailableResponse;
import com.example.stepwise_back.domain.base.NullResponse;
import com.example.stepwise_back.domain.base.ResponseDTO;
import com.example.stepwise_back.domain.users.controller.dto.requeset.UserRegisterRequest;
import com.example.stepwise_back.domain.users.service.UserService;
import com.example.stepwise_back.domain.users.service.dto.input.UserRegisterInput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @GetMapping("/check-id")
    public ResponseEntity<ResponseDTO<AvailableResponse>> isUserIdDuplicated(@RequestParam(name = "userId") String userId){

        return ResponseEntity.ok().body(ResponseDTO.<AvailableResponse>builder()
                .isSuccess(true)
                .stateCode(200)
                .result(AvailableResponse.builder().available(userService.validateUserIdUniqueness(userId)).build()).build());
    }

    @PostMapping("")
    public ResponseEntity<ResponseDTO<AvailableResponse>> userRegister(@RequestBody UserRegisterRequest userRegisterRequest){

        var registerResult = userService.register(new UserRegisterInput(userRegisterRequest));

        var availableResponse = AvailableResponse.builder()
                .available(registerResult.available())
                .build();

        var responseDto = ResponseDTO.<AvailableResponse>builder()
                .isSuccess(true)
                .stateCode(HttpStatus.OK.value())
                .result(availableResponse)
                .build();

        return ResponseEntity.ok(responseDto);
    }
}
