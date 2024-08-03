package com.example.ProductManager.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;
    
    public void publishUpdateMessage(String msg){
        kafkaTemplate.send("UPDATE_TOPIC",msg);
        
    }
    
    
}
