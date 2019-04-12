package com.example.exercicejpa.model;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_event")
    @SequenceGenerator(name = "seq_event", sequenceName = "event_sequence", allocationSize = 1)
    private Integer id;
    private String title;
    private String description;
    @Column(name = "begindate")
    private LocalDate beginDate;
    @Column(name = "alldays")
    private Boolean allDays;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id", referencedColumnName = "fk_address_event")
    private Address address;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_creator", referencedColumnName = "id")
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_item_event", referencedColumnName = "id")
    @MapKey(name = "id")
    private Map<Integer, Item> items;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "guest_event", joinColumns={@JoinColumn(name="fk_event")}, inverseJoinColumns = {@JoinColumn(name="fk_guest")})
    @MapKey(name = "id")
    private Map<Integer, Guest> guests;


}