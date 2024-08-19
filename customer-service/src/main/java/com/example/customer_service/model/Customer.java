package com.example.customer_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_data")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String customerName;
    String email;
    String phoneNumber;

}
