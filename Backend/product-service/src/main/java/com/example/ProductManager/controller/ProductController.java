package com.example.ProductManager.controller;

import com.example.ProductManager.dto.ProductDto;
import com.example.ProductManager.event.UpdatePriceEvent;
import com.example.ProductManager.model.Product;
import com.example.ProductManager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID; 


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productservice;
   
    
   
    
    
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductDto>> getProducts(){
        log.info("PRODUCT CONTROLLER products/getProducts: REQUEST TO GET ALL PRODUCTS FROM PRODUCT SERVICE");
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
    log.info("PRODUCT CONTROLLER products/addProduct: REQUEST TO GET ADD A PRODUCT TO PRODUCT SERVICES");
        return productservice.addProduct(productDto);
    }
//    add products from a list of json.
    @PostMapping("/addProducts")
    public ResponseEntity<Void> addProducts(@RequestBody List<ProductDto> productDtos){
        return productservice.addProducts(productDtos);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<ProductDto> deleteById(@RequestParam UUID product_id){
        log.info("PRODUCT CONTROLLER products/delete: REQUEST TO GET delete A PRODUCT IN PRODUCT SERVICES");
        return productservice.deleteById(product_id);
        
    }
//    send an update event to kafka broker with the updated price , the kafka server will send the message to the consumer, where 
//    the data will be taken and then updates the product price in the other microservice.
    @PostMapping("/update")
    public ResponseEntity<Void> updateProductPrice(@RequestBody UpdatePriceEvent updatePriceEvent){
        return productservice.updateProductPrice(updatePriceEvent);
    }
}
