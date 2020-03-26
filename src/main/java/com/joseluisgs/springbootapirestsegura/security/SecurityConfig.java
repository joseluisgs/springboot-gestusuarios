package com.joseluisgs.springbootapirestsegura.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        // Ahora sobreescribimos el método de configuración e ignoramos la seguridad para un conjunto de peticiones
        // La implementaremos más adelante
        web.ignoring().anyRequest();
    }




}