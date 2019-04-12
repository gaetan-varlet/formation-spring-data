package com.example.demoldap.repository;

import com.example.demoldap.model.Person;

import org.springframework.data.ldap.repository.LdapRepository;

public interface PersonRepository extends LdapRepository<Person> {

    public Person findByUid(String uid);

    public Person findByLastName(String lastName);

}