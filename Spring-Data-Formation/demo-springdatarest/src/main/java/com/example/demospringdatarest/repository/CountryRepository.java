package com.example.demospringdatarest.repository;

import com.example.demospringdatarest.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer>{
    
}