package com.example.exercicejpa.controller;

import com.example.exercicejpa.model.Event;
import com.example.exercicejpa.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody Event event){
        eventRepository.save(event);
    }

}