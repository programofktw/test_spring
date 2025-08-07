package com.example.stepwise_back.domain.users.controller;

import com.example.stepwise_back.domain.users.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class UserControllerTest {

    private final UserService userService = Mockito.mock(UserService.class);
    private final UsersController usersController = new UsersController(userService);
    private final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();

    @Test
    @DisplayName("1. 이미 있는 아이디일 때 false 반환 테스트")
    public void givenExistingUserId_whenCheckId_thenReturnFalse() throws Exception {
        when(userService.validateUserIdUniqueness("existingUser")).thenReturn(false);

        mockMvc.perform(get("/users/check-id")
                        .param("userId", "existingUser")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.stateCode").value(200))
                .andExpect(jsonPath("$.result.available").value(false));
    }

    @Test
    @DisplayName("2. 없는 아이디일 때 true 반환 테스트")
    public void givenNewUserId_whenCheckId_thenReturnTrue() throws Exception {
        when(userService.validateUserIdUniqueness("newUser")).thenReturn(true);

        mockMvc.perform(get("/users/check-id")
                        .param("userId", "newUser")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.stateCode").value(200))
                .andExpect(jsonPath("$.result.available").value(true));
    }

    @Test
    @DisplayName("3. 매개변수 없이 호출 시 예외 발생 테스트")
    public void givenNoUserIdParam_whenCheckId_thenBadRequest() throws Exception {
        mockMvc.perform(get("/users/check-id")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}