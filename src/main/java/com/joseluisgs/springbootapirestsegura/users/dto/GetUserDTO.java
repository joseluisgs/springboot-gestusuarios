package com.joseluisgs.springbootapirestsegura.users.dto;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder

// DYO para devolver usuario
public class GetUserDTO {

    private String username;
    private String avatar;
    private Set<String> roles;



}