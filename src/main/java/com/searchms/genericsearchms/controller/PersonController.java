package com.searchms.genericsearchms.controller;

import com.searchms.genericsearchms.model.Person;
import com.searchms.genericsearchms.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public List<Person> findPersonByFirstName(@RequestBody Person person) {

    }
}
