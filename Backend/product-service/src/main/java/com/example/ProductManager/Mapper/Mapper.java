package com.example.ProductManager.Mapper;

import com.example.ProductManager.dto.ProductDto;
import com.example.ProductManager.model.Product;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    
    public static ProductDto MapProducttoProductDto(Product product) {
        return ProductDto.builder()
                .product_id(product.getProduct_id())
                .product_name(product.getProduct_name())
                .product_price(product.getProduct_price())
                .build();
    }
}
