package com.example.order_service.feign_clients;

import com.example.order_service.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service", url = "localhost:8900")
public interface BookServiceClient {
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable long id);
}
