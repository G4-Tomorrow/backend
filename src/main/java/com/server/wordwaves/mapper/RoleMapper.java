package com.server.wordwaves.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.server.wordwaves.dto.request.role.RoleCreationRequest;
import com.server.wordwaves.dto.response.role.RoleResponse;
import com.server.wordwaves.entity.user.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toRole(RoleCreationRequest request);

    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    RoleResponse toRoleResponse(Role role);
}
