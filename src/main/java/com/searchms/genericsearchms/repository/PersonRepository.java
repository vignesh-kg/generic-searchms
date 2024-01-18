package com.searchms.genericsearchms.repository;


import com.searchms.genericsearchms.model.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface PersonRepository { //extends ElasticsearchRepository<Person, String>
    List<Person> findPersonByFirstname(String firstname);

}
