package com.example.andi.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * WebSecurityConfig with a default denyAll filter chain. The filter chain has order 2, so it will be
 * the last custom Spring Security filter chain that is applied and picked up by the
 * {@link org.springframework.security.web.FilterChainProxy}.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigDefaultFilterConfig {

    @Bean
    @Order(2)
    SecurityFilterChain defaultSecFilterChain(HttpSecurity http) throws Exception {
        http.securityMatchers(matchers -> matchers.requestMatchers("/**"));
        http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll());

        return http.build();
    }
}
