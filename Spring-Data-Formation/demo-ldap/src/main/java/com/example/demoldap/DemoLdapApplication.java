package com.example.demoldap;

import com.example.demoldap.model.Person;
import com.example.demoldap.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoLdapApplication  implements CommandLineRunner{

	@Autowired
	protected PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoLdapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Iterable<Person> people = personRepository.findAll();
		people.forEach(System.out::println);
		// { dn='uid=jahn,ou=people,dc=data,dc=com', uid='jahn', fullName='Jahn Dae', lastName='Jahn', group='people'}
		// { dn='uid=jihn,ou=people,dc=data,dc=com', uid='jihn', fullName='Jihn Die', lastName='Jihn', group='people'}
		// { dn='uid=john,ou=people,dc=data,dc=com', uid='john', fullName='John Doe', lastName='John', group='people'}
	}

}
