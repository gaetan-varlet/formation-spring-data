package com.example.exercicejpa.repository;

import com.example.exercicejpa.model.Guest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

    Iterable<Guest> findByName(String name);

}