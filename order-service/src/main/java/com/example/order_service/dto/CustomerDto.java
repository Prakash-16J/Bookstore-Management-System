package com.example.order_service.dto;

public record CustomerDto(
        long id,
        String customerName,
        String email,
        String phoneNumber
) {
}
