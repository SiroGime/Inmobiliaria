package com.Inmobiliaria.Inmueble.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // públicos (catálogo)
                .requestMatchers(HttpMethod.GET, "/casa/**", "/departamento/**", "/local/**", "/ph/**", "/terreno/**", "/inmueble/**").permitAll()

                // privados (panel inmobiliario)
                .requestMatchers(HttpMethod.POST, "/casa/**", "/departamento/**", "/local/**", "/ph/**", "/terreno/**").hasAnyRole("ADMIN", "AGENTE")
                .requestMatchers(HttpMethod.PUT, "/**").hasAnyRole("ADMIN", "AGENTE")
                .requestMatchers(HttpMethod.DELETE, "/**").hasAnyRole("ADMIN", "AGENTE")

                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}