package com.joseluisgs.springbootapirestsegura.users.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService") // Nombre para inyectarlo posteriormente
@RequiredArgsConstructor // Lombock para inyectar el nuestro usertEntity
public class CustomUserDetailsService implements UserDetailsService {

    private final UserEntityService userEntityService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userEntityService.findUserByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username + " no encontrado"));
    }

}