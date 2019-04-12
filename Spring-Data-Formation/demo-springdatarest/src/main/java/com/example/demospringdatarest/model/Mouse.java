package com.example.demospringdatarest.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Mouse {

    @Id
    private Integer id;
    private String nom;
    
}