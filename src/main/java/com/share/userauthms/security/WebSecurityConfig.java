package com.share.userauthms.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**",
            // other public endpoints of your API may be appended to this array
            "/actuator/health"
    };

    @Value("${spring.config.activate.on-profile}")
    private String activeProfile;


    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        if ("local".equals(activeProfile)) {
            // Configure security for the 'local' profile (e.g., disable authentication)
            http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(requests -> requests
                            .requestMatchers("/**").permitAll()
                            .anyRequest().authenticated()
                    );
            return http.build();
        }

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(AUTH_WHITELIST).permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }

}