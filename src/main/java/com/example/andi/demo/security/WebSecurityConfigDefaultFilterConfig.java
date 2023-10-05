package com.example.andi.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigDefaultFilterConfig {

    @Bean
    @Order(2)
    SecurityFilterChain defaultSecFilterChain(HttpSecurity http) throws Exception {
        http.securityMatchers(matchers -> {
            matchers.requestMatchers("/**");
        });
        http.authorizeHttpRequests(requests -> {
            requests.anyRequest().denyAll();
        });

        return http.build();
    }
}
