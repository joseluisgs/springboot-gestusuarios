package com.joseluisgs.springbootapirestsegura.users.dto;

import java.util.stream.Collectors;

import com.joseluisgs.springbootapirestsegura.users.model.UserEntity;
import com.joseluisgs.springbootapirestsegura.users.model.UserRol;
import org.springframework.stereotype.Component;



@Component
// Comvierte el DTO en clase UserEntity
public class UserDTOConverter {

    public GetUserDTO convertUserEntityToGetUserDTO(UserEntity user) {
        // Me gusta más usar Lombok que model mapper o map ... Preferencia personal
        return GetUserDTO.builder()
                .username(user.getUsername())
                .avatar(user.getAvatar())
                .roles(user.getRoles().stream()
                        .map(UserRol::name)
                        .collect(Collectors.toSet())
                ).build();
    }

}