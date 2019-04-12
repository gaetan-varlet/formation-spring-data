package com.example.exercicejpa.controller;

import com.example.exercicejpa.model.Guest;
import com.example.exercicejpa.repository.GuestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("guest")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    public Iterable<Guest> findAll(){
        return guestRepository.findAll();
    }

    public Iterable<Guest> findByName(@PathVariable String name){
        return guestRepository.findByName(name);
    }

}