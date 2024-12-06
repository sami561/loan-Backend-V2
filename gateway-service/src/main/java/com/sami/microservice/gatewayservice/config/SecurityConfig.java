package com.sami.microservice.gatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
        return httpSecurity
                .csrf(csrf->csrf.disable())
                .authorizeExchange(ex->ex.pathMatchers("/eureka/**")
                        .permitAll()
                        .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oa -> oa.jwt(Customizer.withDefaults()))
                .build();

    }
}
