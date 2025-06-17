package com.example.court_reserve.controller.response;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String email) {
}
