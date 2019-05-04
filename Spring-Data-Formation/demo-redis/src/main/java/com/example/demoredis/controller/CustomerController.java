package com.example.demoredis.controller;

import com.example.demoredis.model.Customer;
import com.example.demoredis.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping
    public void add(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @GetMapping
    public Iterable<Customer> findAll(@RequestParam(required = false) String externalId){
        if(externalId != null){
            return customerRepository.findByExternalId(externalId);
        }
        return customerRepository.findAll();
    }

    @GetMapping("{id}")
    public Customer findById(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    
    
}