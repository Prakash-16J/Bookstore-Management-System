package com.example.customer_service.dto;

import jakarta.validation.constraints.NotEmpty;

public record CustomerDto(

        long id,
        String customerName,
        String email,
        String phoneNumber

) {
}
