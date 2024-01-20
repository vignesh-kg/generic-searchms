package com.searchms.genericsearchms.controller;

import com.searchms.genericsearchms.model.GenericObject;
import com.searchms.genericsearchms.model.SearchObject;
import com.searchms.genericsearchms.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchController {

    @Autowired
    private SearchRepository searchRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/getAll")
    public List<GenericObject> findPersonByFirstName() throws IOException {
        return searchRepository.findAll();
    }

    @GetMapping("/get")
    public List<GenericObject> findBySearchField(@RequestBody SearchObject searchObject)
    {
        Criteria criteria = new Criteria("map."+searchObject.getSearchField()).is(searchObject.getSearchValue());
        Query query = new CriteriaQuery(criteria);
        List<GenericObject> response = new ArrayList<>();
        SearchHits<GenericObject> searchResponse = elasticsearchTemplate.search(query, GenericObject.class);
        if(!CollectionUtils.isEmpty(searchResponse.getSearchHits()))
        {
            for(SearchHit<GenericObject> searchHit : searchResponse.getSearchHits())
            {
                response.add((GenericObject) searchHit.getContent());
            }
        }
        return response;
    }
}