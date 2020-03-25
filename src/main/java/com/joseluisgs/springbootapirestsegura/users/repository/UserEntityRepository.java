package com.joseluisgs.springbootapirestsegura.users.repository;

import com.joseluisgs.springbootapirestsegura.users.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    // Busca un usuario si existe
    Optional<UserEntity> findByUsername(String username);

}
