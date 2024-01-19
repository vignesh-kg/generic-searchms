package com.searchms.genericsearchms.controller;

import com.searchms.genericsearchms.model.GenericObject;
import com.searchms.genericsearchms.repository.PersonRepository;
import com.searchms.genericsearchms.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;
    @GetMapping("/person")
    public List<GenericObject> findPersonByFirstName(@RequestBody String firstname) {
//        return personRepository.findPersonByFirstname(firstname);
        return new ArrayList<>();
    }
}
