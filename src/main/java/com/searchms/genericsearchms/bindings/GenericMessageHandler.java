package com.searchms.genericsearchms.bindings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.searchms.genericsearchms.model.Person;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GenericMessageHandler {
    private static Logger logger = LoggerFactory.getLogger(GenericMessageHandler.class);
    @KafkaListener(topics = "examplev2")
    void consumeMessage(ConsumerRecord<String, String> record) {

        Person json = jsonMapper(record);
        logger.info("{}", json);
    }

    private Person jsonMapper(ConsumerRecord<String, String> records) {

        JsonMapper jsonMapper = new JsonMapper();
        Person person = null;
 //       records.forEach(record -> {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writeValueAsString(records.value());
                person = jsonMapper.convertValue(json, Person.class);
                System.out.println(person);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return person;
     //   });
    }
}
