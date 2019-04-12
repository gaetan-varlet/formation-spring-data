package com.example.demospringdatarest.repository;

import com.example.demospringdatarest.model.Mouse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MouseRepository extends JpaRepository<Mouse, Integer>{

    
}