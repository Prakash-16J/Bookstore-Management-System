package com.example.order_service.dto;

public record OrderDto(
        long id,
        CustomerDto customerDto,
        BookDto bookDto,
        long quantity,
        String status
) {
}
