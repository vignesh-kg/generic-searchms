package com.searchms.genericsearchms.bindings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.searchms.genericsearchms.model.Person;
import com.searchms.genericsearchms.service.PersonService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GenericMessageHandler {

    private static Logger logger = LoggerFactory.getLogger(GenericMessageHandler.class);

    @Autowired
    PersonService personService;
    @KafkaListener(topics = "examplev2")
    void consumeMessage(ConsumerRecord<String, String> record) {

        Person json = jsonMapper(record);
        logger.info("{} {}", json.getFirstname(), json.getLastname());

        personService.savePersonToElasticSearch(json);
    }

    private Person jsonMapper(ConsumerRecord<String, String> record) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String json = record.value();
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println(person);
            return person;
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
