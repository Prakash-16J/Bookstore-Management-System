package com.example.order_service.service;

import com.example.order_service.domain.OrderPurchases;
import com.example.order_service.exception.OrderNotFoundException;
import com.example.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderPurchases> getAllOrders(){
        return orderRepository.findAll();
    }

    public OrderPurchases getOrderById(long id){
        Optional<OrderPurchases> order = orderRepository.findById(id);
        if (order.isPresent()){
            return order.get();
        }
        else throw new OrderNotFoundException("Order not found with this id" + id);
    }

    public OrderPurchases updateOrder(long id, OrderPurchases order) {
        Optional<OrderPurchases> existingOrder = orderRepository.findById(id);
        if(existingOrder.isPresent()){
            existingOrder.get().setCustomerId(order.getCustomerId());
            existingOrder.get().setBookId(order.getBookId());
            existingOrder.get().setQuantity(order.getQuantity());
            existingOrder.get().setStatus(order.getStatus());
            return orderRepository.save(existingOrder.get());
        }
        throw new OrderNotFoundException("Order not found");
    }


    public OrderPurchases addOrder(OrderPurchases order) {
        return orderRepository.save(order);
    }
}
