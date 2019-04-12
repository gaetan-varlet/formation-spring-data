package com.example.demojdbc.ex1.data;

import org.springframework.data.annotation.Id;

public class Pet {

    @Id
    private Integer id;
    private String name;
    private String species;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}