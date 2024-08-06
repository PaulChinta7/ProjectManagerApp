package com.example.UpdateService;

import com.example.UpdateService.event.UpdatePriceEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class UpdateServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UpdateServiceApplication.class, args);
    }
    
    
//    @KafkaListener(topics = "UPDATE_TOPIC",groupId = "my-group")
//    public void consume(String msg){
//        System.out.println(msg);
//    }


    @KafkaListener(topics = "UPDATE_TOPIC",groupId = "my-group")
    public void consumeObject(UpdatePriceEvent updatePriceEvent){
        System.out.println(updatePriceEvent.getUpdated_price());
        
    }
}