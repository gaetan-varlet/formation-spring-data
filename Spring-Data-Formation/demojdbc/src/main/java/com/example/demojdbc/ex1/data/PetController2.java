package com.example.demojdbc.ex1.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pet2")
public class PetController2 {

    @Autowired
    private PetRepository2 petRepository2;

    @GetMapping
    public Iterable<Pet> findAll(@RequestParam(required = false) String name) {
        if(name != null){
            return petRepository2.findByName(name);
        }
        return petRepository2.findAll();
    }
}