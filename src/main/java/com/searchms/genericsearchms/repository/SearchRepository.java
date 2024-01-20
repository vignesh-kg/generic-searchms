package com.searchms.genericsearchms.repository;


import com.searchms.genericsearchms.model.GenericObject;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends ElasticsearchRepository<GenericObject, String> {
    List<GenericObject> findAll();
}
