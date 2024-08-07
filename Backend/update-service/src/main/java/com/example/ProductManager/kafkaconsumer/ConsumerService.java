package com.example.ProductManager.kafkaconsumer;

import com.example.ProductManager.UpdateServiceApplication;
import com.example.ProductManager.dao.ProductDao;
import com.example.ProductManager.event.UpdatePriceEvent;
import com.example.ProductManager.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsumerService {
    private static final Logger log = LoggerFactory.getLogger(UpdateServiceApplication.class);
    @Autowired    
    private ProductDao productDao;
    
    
    @KafkaListener(topics = "ABC_TOPIC",groupId ="my-group")
    public void consume(UpdatePriceEvent updatePriceEvent){
        try {
            
            Optional<Product> product = productDao.findById(updatePriceEvent.getId());
            if (product.isPresent()) {
                Product newproduct = Product.builder()
                        .product_id(product.get().getProduct_id())
                        .product_price(updatePriceEvent.getPrice())
                        .product_name(product.get().getProduct_name())
                        .build();
                productDao.save(newproduct);
                log.info("UPDATED PRICE ADDED TO THE DATABASE msg:{}",updatePriceEvent.getMsg());
            }
            else{
                log.info("PRODUCT IS NOT FOUND IN THE DATABASE");
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            }
      
    }
}
