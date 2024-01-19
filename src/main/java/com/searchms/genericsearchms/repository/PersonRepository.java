package com.searchms.genericsearchms.repository;


import com.searchms.genericsearchms.model.GenericObject;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PersonRepository extends ElasticsearchRepository<GenericObject, String> {
//    List<GenericObject> findPersonByFirstname(String firstname);

}
