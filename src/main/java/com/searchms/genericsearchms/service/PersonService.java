package com.searchms.genericsearchms.service;

import com.searchms.genericsearchms.model.Person;
import com.searchms.genericsearchms.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersonByFirstName(String firstName) {

        return personRepository.findPersonByFirstname(firstName);

    }

}
