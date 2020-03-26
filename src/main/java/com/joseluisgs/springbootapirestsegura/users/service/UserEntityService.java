package com.joseluisgs.springbootapirestsegura.users.service;

import com.joseluisgs.springbootapirestsegura.error.exception.NewUserWithDifferentPasswordsException;
import com.joseluisgs.springbootapirestsegura.services.base.BaseService;
import com.joseluisgs.springbootapirestsegura.users.dto.CreateUserDTO;
import com.joseluisgs.springbootapirestsegura.users.model.UserEntity;
import com.joseluisgs.springbootapirestsegura.users.model.UserRol;
import com.joseluisgs.springbootapirestsegura.users.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor // Inyección por costructor
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> {

    private final PasswordEncoder passwordEncoder; // Inyección por costructor

    /**
     * Nos permite buscar un usuario por su nombre de usuario
     *
     * @param username
     * @return
     */
    public Optional<UserEntity> findUserByUsername(String username) {
        return this.repositorio.findByUsername(username);
    }

    /**
     * Nos permite crear un nuevo UserEntity con rol USER
     *
     * @param newUser
     * @return
     */
    public UserEntity nuevoUsuario(CreateUserDTO newUser) {

        if (newUser.getPassword().contentEquals(newUser.getPassword2())) {
            UserEntity userEntity = UserEntity.builder().username(newUser.getUsername())
                    .password(passwordEncoder.encode(newUser.getPassword())).avatar(newUser.getAvatar())
                    .roles(Stream.of(UserRol.USER).collect(Collectors.toSet())).build();
            try {
                return save(userEntity);
            } catch (DataIntegrityViolationException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
            }
        } else {
            throw new NewUserWithDifferentPasswordsException();
        }

    }

}