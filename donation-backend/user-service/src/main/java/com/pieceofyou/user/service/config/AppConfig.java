package com.pieceofyou.user.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
    @Value("${persistence.service.url}")
    private String persistenceServiceUrl;
    @Bean
    public WebClient userServiceProxyClient() {
        return WebClient.builder()
                .baseUrl(persistenceServiceUrl)
                .build();
    }
}
