package com.example.order_service.feign_clients;

import com.example.order_service.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "localhost:8700")
public interface CustomerServiceClient {
    @GetMapping("/customers/{id}")
    public CustomerDto getCustomerById(@PathVariable long id);
}
