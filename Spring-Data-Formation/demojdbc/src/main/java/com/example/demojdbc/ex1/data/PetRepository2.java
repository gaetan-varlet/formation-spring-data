package com.example.demojdbc.ex1.data;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PetRepository2 extends CrudRepository<Pet, Integer>{

    @Query("select * from pet where name = :name")
    public List<Pet> findByName(@Param("name") String name);
    
}