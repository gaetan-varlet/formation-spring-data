package com.example.demojdbc.ex1.data;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping
    public Iterable<Pet> findAll() {
        return petRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Pet> findById(@PathVariable Integer id) {
        return Optional.ofNullable(petRepository.findById(id));
    }

    @PostMapping
    public int save(@RequestBody Pet pet){
        return petRepository.save(pet);
    }

    @DeleteMapping("{id}")
    public int deleteById(@PathVariable Integer id){
        return petRepository.deleteById(id);
    }

}