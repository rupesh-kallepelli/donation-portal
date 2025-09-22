package com.pieceofyou.user.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class AppConfig {
        @Configuration
        public class WebConfig {
                private static final String SECURITY_SCHEME_NAME = "API Gateway Authentication";

                @Bean
                public OpenAPI customOpenAPI() {
                        return new OpenAPI()
                                        .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME_NAME))
                                        .components(new Components()
                                                        .addSecuritySchemes(SECURITY_SCHEME_NAME,
                                                                        new SecurityScheme()
                                                                                        .name("Authorization")
                                                                                        .type(SecurityScheme.Type.HTTP)
                                                                                        .scheme("bearer")
                                                                                        .bearerFormat("JWT")));
                }
        }

        @Value("${persistence.service.url}")
        private String persistenceServiceUrl;

        @Bean
        public WebClient userServiceProxyClient() {
                return WebClient.builder()
                                .baseUrl(persistenceServiceUrl)
                                .build();
        }
}
