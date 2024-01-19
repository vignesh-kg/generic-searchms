package com.searchms.genericsearchms.service;

import com.searchms.genericsearchms.model.GenericObject;
import com.searchms.genericsearchms.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<GenericObject> getPersonByFirstName(String firstName) {
//        return personRepository.findPersonByFirstname(firstName);
        return Collections.emptyList();
    }

    public void savePersonToElasticSearch(Map<String,Object> map) {

        GenericObject go = new GenericObject();
        go.setMap(map);
        personRepository.save(go);

    }

}
