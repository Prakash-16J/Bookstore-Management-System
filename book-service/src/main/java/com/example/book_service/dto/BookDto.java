package com.example.book_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record BookDto(
        long id,
        String tile,
        String author,
        int price,
        int stock


) {
}
