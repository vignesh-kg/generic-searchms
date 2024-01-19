package com.searchms.genericsearchms.bindings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchms.genericsearchms.service.ElasticsearchService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GenericMessageHandler {
    private static Logger logger = LoggerFactory.getLogger(GenericMessageHandler.class);

    @Autowired
    ElasticsearchService personService;
    @KafkaListener(topics = "examplev2")
    void consumeMessage(ConsumerRecord<String, String> record) {

        Map<String,Object> json = jsonMapper(record);
        personService.savePersonToElasticSearch(json);
    }

    private Map<String,Object> jsonMapper(ConsumerRecord<String, String> record) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String json = record.value();
            Map<String,Object> map = objectMapper.readValue(json, Map.class);
            System.out.println(map);
            return map;
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
