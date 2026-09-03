package com.example.demo.service.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.dto.ExternalUser;
import com.example.demo.dto.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final WebClient webClient;

    public UserResponse getUser(Integer id) {

        ExternalUser externalUser = webClient
                .get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(ExternalUser.class)
                .block();

        if (externalUser == null) {
            throw new RuntimeException("User not found");
        }

        return new UserResponse(
                externalUser.getId(),
                externalUser.getUsername().toUpperCase(),
                externalUser.getEmail(),
                "https://" + externalUser.getWebsite(),
                "External User Service");
    }

    public List<UserResponse> getAllUsers() {

        List<ExternalUser> externalUsers = webClient
                .get()
                .uri("/users")
                .retrieve() // Mono<T>
                .bodyToMono(new ParameterizedTypeReference<List<ExternalUser>>() {
                })
                .block();

        if (externalUsers == null) {
            throw new RuntimeException("Users not found");
        }

        return externalUsers.stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getUsername().toUpperCase(),
                        user.getEmail(),
                        "https://" + user.getWebsite(),
                        "External User Service"))
                .toList();

    }

}
