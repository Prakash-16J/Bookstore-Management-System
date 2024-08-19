package com.example.order_service.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderPurchases {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long customerId;
    long bookId;
    long quantity;
    String status;
}
