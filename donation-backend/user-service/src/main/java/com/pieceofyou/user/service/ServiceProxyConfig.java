package com.pieceofyou.user.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ServiceProxyConfig {
    @Value("${userservice.url}")
    private String userServiceUrl;

    @Bean
    public WebClient userServiceProxyClient() {
        return WebClient.builder().baseUrl(userServiceUrl).build();
    }

}
