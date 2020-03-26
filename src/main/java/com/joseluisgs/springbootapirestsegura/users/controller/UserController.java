package com.joseluisgs.springbootapirestsegura.users.controller;

import com.joseluisgs.springbootapirestsegura.users.dto.CreateUserDTO;
import com.joseluisgs.springbootapirestsegura.users.dto.GetUserDTO;
import com.joseluisgs.springbootapirestsegura.users.dto.UserDTOConverter;
import com.joseluisgs.springbootapirestsegura.users.model.UserEntity;
import com.joseluisgs.springbootapirestsegura.users.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserEntityService userEntityService;
    private final UserDTOConverter userDTOConverter;


    @PostMapping("/")
    public GetUserDTO nuevoUsuario(@RequestBody CreateUserDTO newUser) {
        // Creamos el usuario a traves de su DTO de entrada y lo salvamos. Luego devolvemos el resultado
        // Tranformándolo en el DTO de salida
        return userDTOConverter.convertUserEntityToGetUserDTO(userEntityService.nuevoUsuario(newUser));

    }

}