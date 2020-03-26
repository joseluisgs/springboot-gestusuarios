package com.joseluisgs.springbootapirestsegura.users.service;

import com.joseluisgs.springbootapirestsegura.services.base.BaseService;
import com.joseluisgs.springbootapirestsegura.users.model.UserEntity;
import com.joseluisgs.springbootapirestsegura.users.model.UserRol;
import com.joseluisgs.springbootapirestsegura.users.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor // Inyección por costructor
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> {

    private final PasswordEncoder passwordEncoder; // Inyección por costructor

    /**
     * Nos permite buscar un usuario por su nombre de usuario
     * @param username
     * @return
     */
    public Optional<UserEntity> findUserByUsername(String username) {
        return this.repositorio.findByUsername(username);
    }

    /**
     * Nos permite crear un nuevo UserEntity con rol USER
     * @param userEntity
     * @return
     */
    public UserEntity nuevoUsuario(UserEntity userEntity) {
        // Ciframos sus password
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        // Le asignamos el rol
        userEntity.setRoles(Stream.of(UserRol.USER).collect(Collectors.toSet()));
        return save(userEntity);
    }


}