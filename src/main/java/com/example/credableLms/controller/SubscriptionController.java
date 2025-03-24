package com.example.credableLms.controller;

import com.example.credableLms.model.Customer;
import com.example.credableLms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public String subscribe(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Customer registered successfully!";
    }
}
