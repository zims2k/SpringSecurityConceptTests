package com.example.andi.demo;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Custom header filter without Spring Security. This filter is applied directly into the
 * {@link org.apache.catalina.core.ApplicationFilterChain}, so no firewalling with Spring Security is in place!! This is
 * just for demonstration purpose.
 */
@Component
@Slf4j
public class MyHeaderFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logRequest(request);

        filterInOut(request, response, filterChain);

        logResponse(response);
    }

    private static void logRequest(HttpServletRequest request) {
        log.trace("Request headers:");

        ArrayList<String> rqHeaders = Collections.list(request.getHeaderNames());

        rqHeaders.forEach(header -> log.trace(String.format(" %-30s: %s", header, request.getHeader(header))));
    }

    private static void logResponse(HttpServletResponse response) {
        log.trace("Response headers:");

        Collection<String> headerNames = response.getHeaderNames();
        headerNames.forEach(header -> log.trace(String.format(" %-30s: %s", header, response.getHeader(header))));
    }

    private static void filterInOut(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(request, response);
    }
}
