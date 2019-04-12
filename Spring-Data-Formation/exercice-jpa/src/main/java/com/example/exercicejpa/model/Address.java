package com.example.exercicejpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_adresse")
    @SequenceGenerator(name = "seq_adresse", sequenceName = "address_sequence", allocationSize = 1)
    private Integer id;
    private String name;
    private String street;
    private String comments;
    @Column(name = "zipcode")
    private String zipCode;
    private String city;

}