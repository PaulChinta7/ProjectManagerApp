package com.example.ProductManager.dao;


import com.example.ProductManager.exception.ProductNotFoundException;
import com.example.ProductManager.model.Product;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@RequiredArgsConstructor
public class ProductDaoTests {
    @Autowired
    private ProductDao productDao;
    
    @Test
    public void ProductDao_addProduct_ReturnsProductNotNull(){
        Product product= Product.builder()
                .product_name("Rice")
                .product_price(20.99)
                .build();
        Product product_from_db=productDao.save(product);
        System.out.println(product_from_db.getProduct_name());
        Assertions.assertNotNull(product_from_db);
    }
    
    @Test
    public void ProductDao_findAll_ReturnsProductNotNull(){
        List<Product> productList=productDao.findAll();
        
        Assertions.assertNotNull(productList);
    }
    @Test
    public void ProductDao_deleteProductById_ReturnsProductNull(){
        Product product= Product.builder()
                .product_name("Water bottle")
                .product_price(5.99)
                .build();
        Product product_from_db=productDao.save(product);
        
        productDao.deleteById(product_from_db.getProduct_id());
        
        Optional<Product> product_found=productDao.findById(product_from_db.getProduct_id());
        if(product_found.isEmpty()){
        Assertions.assertEquals(product_found,Optional.empty());
        
        }
        else throw new ProductNotFoundException("Product is not found in the database with id"+product_found.get().getProduct_id().toString());
        
    }
}
