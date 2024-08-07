package com.example.ProductManager;

import com.example.ProductManager.event.UpdatePriceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class UpdateServiceApplication {
 
    public static void main(String[] args) {
        SpringApplication.run(UpdateServiceApplication.class, args);
    }
    
  
}
