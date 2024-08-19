package com.example.customer_service.service;

import com.example.customer_service.exceptions.CustomerNotFoundException;
import com.example.customer_service.model.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return customer.get();
        }
        throw new CustomerNotFoundException("Customer not found with this id:" + id);
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedetails){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            Customer updateCustomer = customer.get();
            updateCustomer.setCustomerName(updatedetails.getCustomerName());
            updateCustomer.setEmail(updatedetails.getEmail());
            updateCustomer.setPhoneNumber(updatedetails.getPhoneNumber());
            return customerRepository.save(updateCustomer);
        }else{
            throw new CustomerNotFoundException("Customer Not Found");
        }

    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }



}
