package com.example.customer_service.converter;

import com.example.customer_service.dto.CustomerDto;
import com.example.customer_service.model.Customer;
import org.springframework.stereotype.Component;


@Component
public class CustomerDtoConverter {

      public CustomerDto convertToDto(Customer customer){
          return new CustomerDto(
                  customer.getId(),
                  customer.getCustomerName(),
                  customer.getEmail(),
                  customer.getPhoneNumber()
          );
      }

      public Customer convertToEntity(CustomerDto customerDto){
          return new Customer(
                  customerDto.id(),
                  customerDto.customerName(),
                  customerDto.email(),
                  customerDto.phoneNumber()
          );
      }
}
