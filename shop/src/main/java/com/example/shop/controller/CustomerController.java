package com.example.shop.controller;

import com.example.shop.model.Customer;
import com.example.shop.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

//    @PostMapping
//    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
//        Customer customer1 = customerService.addCustomer(customer);
//        return ResponseEntity.ok(customer1);
//    }
}
