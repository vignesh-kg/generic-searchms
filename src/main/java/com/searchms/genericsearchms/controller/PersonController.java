package com.searchms.genericsearchms.controller;

import com.searchms.genericsearchms.model.GenericObject;
import com.searchms.genericsearchms.repository.PersonRepository;
import com.searchms.genericsearchms.service.ElasticsearchService;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private ElasticsearchService personService;

//    @Autowired
//    private PersonRepository personRepository;
    @GetMapping("/person")
    public SearchResponse findPersonByFirstName(@RequestBody String firstname) throws IOException {
//        return personRepository.findPersonByFirstname(firstname);
        return personService.executeGenericQuery();
//        return new ArrayList<>();
    }
}
