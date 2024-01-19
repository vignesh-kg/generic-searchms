package com.searchms.genericsearchms.service;

import com.searchms.genericsearchms.model.GenericObject;
import com.searchms.genericsearchms.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

@Service
public class ElasticsearchService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

//    public ElasticsearchService(RestHighLevelClient restHighLevelClient) {
//        this.restHighLevelClient = restHighLevelClient;
//    }

    public SearchResponse executeGenericQuery() throws IOException {
        SearchRequest searchRequest = new SearchRequest("generic");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());

        searchRequest.source(searchSourceBuilder);

        return restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    }

    public void savePersonToElasticSearch(Map<String,Object> map) {
        GenericObject go = new GenericObject();
        go.setMap(map);
        personRepository.save(go);
    }
}
