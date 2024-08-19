package com.example.customer_service.controller;

import com.example.customer_service.converter.CustomerDtoConverter;
import com.example.customer_service.dto.CustomerDto;
import com.example.customer_service.model.Customer;
import com.example.customer_service.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerDtoConverter converter;

    public CustomerController(CustomerService customerService, CustomerDtoConverter converter) {
        this.customerService = customerService;
        this.converter = converter;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
         return customerService.getAllCustomer();
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomerById(@PathVariable long id){
        return converter.convertToDto(customerService.getCustomerById(id));
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/update")
    public Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
    }




}
