package com.example.andi.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigSpecialAndNoAuthAuthFilterConfig {

    @Bean
    @Order(0)
    SecurityFilterChain appSecFilterChain(HttpSecurity http) throws Exception {
        http.securityMatchers(matchers -> {
            matchers.requestMatchers("/app/**");
        });

        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(requests -> {
            requests.anyRequest().authenticated();
        });

        return http.build();
    }

    @Bean
    @Order(1)
    SecurityFilterChain noAuthSecFilterChain(HttpSecurity http) throws Exception {
        http.securityMatchers(matchers -> {
            matchers.requestMatchers("/other/**", "/error");
        });
        http.authorizeHttpRequests(requests -> {
            requests.anyRequest().permitAll();
        });

        return http.build();
    }
}
