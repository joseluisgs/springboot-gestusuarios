package com.joseluisgs.springbootapirestsegura.users.service;

import com.joseluisgs.springbootapirestsegura.services.base.BaseService;
import com.joseluisgs.springbootapirestsegura.users.model.UserEntity;
import com.joseluisgs.springbootapirestsegura.users.repository.UserEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> {


    public Optional<UserEntity> findUserByUsername(String username) {
        return this.repositorio.findByUsername(username);
    }


}