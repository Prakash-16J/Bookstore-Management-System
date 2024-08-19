package com.example.customer_service.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String customerNotFound) {
        super(customerNotFound);
    }
}
