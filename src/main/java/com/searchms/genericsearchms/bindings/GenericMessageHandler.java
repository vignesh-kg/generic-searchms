package com.searchms.genericsearchms.bindings;

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
        logger.info("{}", record.value());
    }
}
