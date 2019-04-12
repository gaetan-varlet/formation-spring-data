package com.example.exercicejpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_guest")
    @SequenceGenerator(name = "seq_guest", sequenceName = "guest_sequence", allocationSize = 1)
    private Integer id;
    private String name;
    private String email;
}