package com.example.demomongodb.controller;

import com.example.demomongodb.model.Domain;
import com.example.demomongodb.repository.DomainRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("domain")
public class DomainController {

    @Autowired
    private DomainRepository domainRepository;

    @GetMapping
    public Iterable<Domain> findAll() {
        return domainRepository.findAll();
    }

    @GetMapping("create")
    public void create() {
        Domain domain = new Domain();
        domain.setDomain("dawan");
        domain.setDisplayAds(true);

        System.out.println("AVANT : " + domainRepository.count());
        domainRepository.save(domain);
        System.out.println("APRES : " + domainRepository.count());

        domainRepository.update("dawan", false);

    }

}