package com.example.ProductManager.controller;

import com.example.ProductManager.dto.ProductDto;
import com.example.ProductManager.model.Product;
import com.example.ProductManager.producer.KafkaProducer;
import com.example.ProductManager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID; 


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productservice;
    @Autowired
    private KafkaProducer kafkaProducer;
    
    
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductDto>> getProducts(){
        return productservice.getProducts();
    }
    @PostMapping("/getProduct")
    public ResponseEntity<ProductDto> getProduct(@RequestParam String product_name){
        return productservice.getProduct(product_name);
        
    }
//    add a single product to the database
@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productDto){
        return productservice.addProduct(productDto);
    }
//    add products from a list of json.
    @PostMapping("/addProducts")
    public ResponseEntity<Void> addProducts(@RequestBody List<ProductDto> productDtos){
        return productservice.addProducts(productDtos);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<ProductDto> deleteById(@RequestParam UUID product_id){
        return productservice.deleteById(product_id);
        
    }
//    send an update event to kafka broker with the updated price , the kafka server will send the message to the consumer, where 
//    the data will be taken and then updates the product price in the other microservice.
    @PostMapping("/update")
    public ResponseEntity<Void> updateProductPrice(@RequestParam String msg){
        kafkaProducer.publishUpdateMessage(msg);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
}
