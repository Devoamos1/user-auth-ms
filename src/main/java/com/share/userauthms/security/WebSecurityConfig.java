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

    @Value("${spring.config.activate.on-profile}")
    private String activeProfile;

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        if ("local".equals(activeProfile)) {
            // Configure security for the 'local' profile (e.g., disable authentication)
            http
                    .authorizeHttpRequests(requests -> requests
                            .requestMatchers("/*", "/actuator/health", "/swagger", "/v2/api-docs", "/v3/api-docs/**", "/swagger-ui-custom.html").permitAll()
                            .anyRequest().authenticated()
                    );
            return http.build();
        }

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/*").permitAll()
                        .anyRequest().authenticated()
                );
        // ...
        // Disable CSRF for development/testing

        return http.build();
    }

}