package com.example.demospringdatarest.repository;

import com.example.demospringdatarest.model.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "metropolises")
public interface CityRepository extends JpaRepository<City, Integer>{
    
}