package com.sami.microservice.gatewayservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)

public class GlobalSecurityConfiguration {
    private final KeycloakJwtTokenConverter keycloakJwtTokenConverter ;

    public GlobalSecurityConfiguration(TokenConverterProperties properties) {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        this.keycloakJwtTokenConverter = new KeycloakJwtTokenConverter(
                jwtGrantedAuthoritiesConverter,
                properties
        );
    }

    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                sessionManagement(sm ->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(ar -> ar.anyRequest().authenticated())
                .oauth2ResourceServer(oa->oa.jwt(j->j.jwtAuthenticationConverter(keycloakJwtTokenConverter)));
        return http.build();
    }

}
