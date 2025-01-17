package com.server.wordwaves.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.server.wordwaves.dto.request.user.UserCreationRequest;
import com.server.wordwaves.dto.response.user.UserResponse;
import com.server.wordwaves.entity.user.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest request);

    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    UserResponse toUserResponse(User user);
}
