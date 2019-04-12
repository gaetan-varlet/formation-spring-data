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
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item")
    @SequenceGenerator(name = "seq_item", sequenceName = "item_sequence", allocationSize = 1)
    private Integer id;
    private String name;
    @Column(name="neededquantity")
    private Integer neededQuantity;
    @Column(name="currentquantity")
    private Integer currentQuantity;
}