package com.pieceofyou.user.service.serviceproxy;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pieceofyou.model.client.dto.security.request.UserRegistrationRequest;
import com.pieceofyou.model.client.dto.security.response.UserRegistrationResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserServiceProxy {
    private final WebClient userServiceProxyClient;

    public UserServiceProxy(WebClient userServiceProxyClient) {
        this.userServiceProxyClient = userServiceProxyClient;
    }

    public Mono<ResponseEntity<UserRegistrationResponse>> registerUser(UserRegistrationRequest userDTO) {
        return userServiceProxyClient.post()
                .uri("/api/user/register")
                .bodyValue(userDTO)
                .exchangeToMono(response -> {
                    HttpStatusCode status = response.statusCode();
                    Mono<UserRegistrationResponse> bodyMono = response.bodyToMono(UserRegistrationResponse.class);
                    return bodyMono.map(body -> {
                        log.info("Received response from persistence: status={}, body={}", status, body);
                        return ResponseEntity.status(status).body(body);
                    });
                });

    }
}
