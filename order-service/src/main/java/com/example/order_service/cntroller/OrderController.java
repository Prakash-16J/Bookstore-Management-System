package com.example.order_service.cntroller;

import com.example.order_service.domain.OrderPurchases;
import com.example.order_service.dto.BookDto;
import com.example.order_service.dto.OrderDto;
import com.example.order_service.exception.OutOfStockException;
import com.example.order_service.feign_clients.BookServiceClient;
import com.example.order_service.feign_clients.CustomerServiceClient;
import com.example.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService service;
    private final CustomerServiceClient customerServiceClient;
    private final BookServiceClient bookServiceClient;

    public OrderController(OrderService service, CustomerServiceClient customerServiceClient, BookServiceClient bookServiceClient) {
        this.service = service;
        this.customerServiceClient = customerServiceClient;
        this.bookServiceClient = bookServiceClient;
    }

    @PutMapping("{id}")
    public OrderPurchases updateOrder(@PathVariable long id, @RequestBody OrderPurchases order){
        return service.updateOrder(id,order);
    }

    @PostMapping
    public OrderPurchases addOrder(@RequestBody OrderPurchases order){
        return service.addOrder(order);
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable long id){
        OrderPurchases order= service.getOrderById(id);
        BookDto book = bookServiceClient.getBookById(order.getBookId());
        if(book.stock() < order.getQuantity()){
            throw new OutOfStockException("Stock is not enough");
        }

        return new OrderDto(
                order.getId(),
                customerServiceClient.getCustomerById(order.getCustomerId()),
                bookServiceClient.getBookById(order.getBookId()),
                order.getQuantity(),
                order.getStatus()

        );
    }
}
