package com.example.ProductManager.service;


import com.example.ProductManager.Mapper.Mapper;
import com.example.ProductManager.dao.ProductDao;
import com.example.ProductManager.dto.ProductDto;
import com.example.ProductManager.model.Product;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class ProductServiceTests {
    
    @Mock
    private ProductDao productDao;
    @InjectMocks
    private ProductService productService;
    
    @Test
    public void ProductServer_addProduct_ReturnsProductDto(){
        Product product=Product.builder()
                .product_name("Rice")
                .product_price(10.99).build();
        ProductDto product_dto= Mapper.MapProducttoProductDto(product);
        when(productDao.save(Mockito.any(Product.class))).thenReturn(product);

        Assertions.assertEquals(productService.addProduct(product_dto).getBody().getProduct_name(),"Rice");
        Assertions.assertEquals(productService.addProduct(product_dto).getBody().getProduct_price(),10.99);
    }
    
//    @Test
//    public void ProductService_deleteProduct_ReturnsProductDto(){
//        Product product=Product.builder()
//                .product_name("Rice")
//                .product_price(10.99)
//                .build();
//        ProductDto productDto= Mapper.MapProducttoProductDto(product);
//        ProductDto productDao.save(product);
//        when(productDao.findById())
//        
//
//    }
    
    
}
