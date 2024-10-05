package com.server.wordwaves.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.server.wordwaves.dto.request.auth.LogoutRequest;
import com.server.wordwaves.dto.request.user.UserCreationRequest;
import com.server.wordwaves.dto.request.user.UserUpdateRequest;
import com.server.wordwaves.dto.request.user.VerifyEmailRequest;
import com.server.wordwaves.dto.response.auth.AuthenticationResponse;
import com.server.wordwaves.dto.response.common.ApiResponse;
import com.server.wordwaves.dto.response.common.EmailResponse;
import com.server.wordwaves.dto.response.common.PaginationInfo;
import com.server.wordwaves.dto.response.user.UserResponse;
import com.server.wordwaves.service.UserService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;

    @PostMapping
    ApiResponse<EmailResponse> register(@RequestBody @Valid UserCreationRequest request) {
        return ApiResponse.<EmailResponse>builder()
                .result(userService.register(request))
                .build();
    }

    @GetMapping("/verify")
    ApiResponse<AuthenticationResponse> verify(@RequestParam("token") VerifyEmailRequest request) {
        return ApiResponse.<AuthenticationResponse>builder()
                .message("Verify email successfully")
                .result(userService.verify(request))
                .build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestHeader("Authorization") LogoutRequest request) {
        userService.logout(request);
        return ApiResponse.<Void>builder().message("Đăng xuất thành công").build();
    }

    @GetMapping
    ApiResponse<PaginationInfo<List<UserResponse>>> getUsers(
            @RequestParam int pageNumber,
            @RequestParam int pageSize,
            @RequestParam(required = false, defaultValue = "createdAt") String sortBy,
            @RequestParam(required = false, defaultValue = "DESC") String sortDirection,
            @RequestParam(required = false) String searchQuery) {
        return ApiResponse.<PaginationInfo<List<UserResponse>>>builder()
                .message("Get all users")
                .result(userService.getUsers(pageNumber, pageSize, sortBy, sortDirection, searchQuery))
                .build();
    }

    @GetMapping("/myinfo")
    ApiResponse<UserResponse> getMyInfo() {
        return ApiResponse.<UserResponse>builder()
                .message("Get user info")
                .result(userService.getMyInfo())
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUserById(@PathVariable String userId) {
        return ApiResponse.<UserResponse>builder()
                .message("Get a user by id")
                .result(userService.getUserById(userId))
                .build();
    }

    @PutMapping("/{userId}")
    ApiResponse<UserResponse> updateUserById(
            @PathVariable String userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        return ApiResponse.<UserResponse>builder()
                .message("Update user successfully")
                .result(userService.updateUserById(userId, userUpdateRequest))
                .build();
    }

    @DeleteMapping("/{userId}")
    ApiResponse<Void> deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return ApiResponse.<Void>builder().message("Delete a user successfully").build();
    }
}
