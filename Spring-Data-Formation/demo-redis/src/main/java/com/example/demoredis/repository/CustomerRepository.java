package com.example.demoredis.repository;

import com.example.demoredis.model.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Iterable<Customer> findByExternalId(String externalId);

}