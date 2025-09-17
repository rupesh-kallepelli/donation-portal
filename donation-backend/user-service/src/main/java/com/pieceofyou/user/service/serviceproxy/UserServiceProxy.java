package com.pieceofyou.user.service.serviceproxy;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pieceofyou.model.client.userservice.UserDTO;

import reactor.core.publisher.Mono;

@Service
public class UserServiceProxy {
    private final WebClient userServiceProxyClient;

    public UserServiceProxy(WebClient userServiceProxyClient) {
        this.userServiceProxyClient = userServiceProxyClient;
    }

    public Mono<String> registerUser(UserDTO userDTO) {
        return userServiceProxyClient.post()
                .uri("/users/register")
                .bodyValue(userDTO)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                    return clientResponse.bodyToMono(String.class).flatMap(errorMessage -> {
                        System.out.println(errorMessage);
                        return Mono.error(new RuntimeException("Client error: " + errorMessage));
                    });
                })
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> {
                    return clientResponse.bodyToMono(String.class).flatMap(errorMessage -> {
                        System.out.println(errorMessage);
                        return Mono.error(new RuntimeException("Server error: " + errorMessage));
                    });
                })  
                .bodyToMono(String.class);
    }

}
