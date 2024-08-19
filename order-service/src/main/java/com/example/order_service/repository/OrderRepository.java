package com.example.order_service.repository;

import com.example.order_service.domain.OrderPurchases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderPurchases,Long> {
}
