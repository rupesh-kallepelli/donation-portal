package com.pieceofyou.user.service.service.impl;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.pieceofyou.user.service.service.KafkaService;

@Service
public class KafkaProducerImpl implements KafkaService {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void produce(String emailRequest) {
        kafkaTemplate.send("email_topic", emailRequest);
    }
}
