package com.joseluisgs.springbootapirestsegura.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
// DTO para crear usuario, con dos contraseñas
public class CreateUserDTO {

    private String username;
    private String avatar;
    private String password;
    private String password2;

}