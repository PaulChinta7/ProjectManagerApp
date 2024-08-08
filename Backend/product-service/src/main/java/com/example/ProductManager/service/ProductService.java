package com.example.ProductManager.service;

import com.example.ProductManager.dao.ProductDao;
import com.example.ProductManager.dto.ProductDto;
import com.example.ProductManager.exception.ProductNotFoundException;
import com.example.ProductManager.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductDao productdao;


    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> products=productdao.findAllProducts();
        List<ProductDto> product_dtos=products.stream().map(this::MaptoProductDto).toList();
        log.info("PRODUCTSERVICE getProducts: REQUEST TO GET ALL PRODUCTS FROM PRODUCT REPOSITORY");
        return new ResponseEntity<>(product_dtos,HttpStatus.OK);
    }

    public ResponseEntity<ProductDto> getProduct(String productName) {
        Optional<Product> product= Optional.ofNullable(productdao.findByProductName(productName));
        if(product.isPresent()){
            ProductDto productDto= ProductDto.builder().
                    product_id(product.get().getProduct_id())
                    .product_name(product.get().getProduct_name())
                    .product_price(product.get().getProduct_price())
                    .build();
            log.info("PRODUCTSERVICE getProduct: REQUEST TO GET ADD A PRODUCT TO PRODUCT REPOSITORY");
            return new ResponseEntity<ProductDto>(productDto,HttpStatus.OK);
        }
        else{
            throw new ProductNotFoundException("Product is not found in the Database with name->"+productName);
        }
    
    }    

    private ProductDto MaptoProductDto(Product product) {
    return ProductDto.builder()
            .product_id(product.getProduct_id())
            .product_name(product.getProduct_name())
            .product_price(product.getProduct_price())
            .build();
    }
//Handle duplicate entries
    public ResponseEntity<Product> addProduct(ProductDto productDto){
        Product product= Product.builder().product_id(productDto.getProduct_id())
                .product_name(productDto.getProduct_name())
                .product_price((productDto.getProduct_price()))
                .build();
        productdao.save(product);
        
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    public ResponseEntity<Void> addProducts(List<ProductDto> productDtos) {
        for(ProductDto productdto:productDtos){
            Product product= Product.builder().
                    product_name(productdto.getProduct_name())
                    .product_price(productdto.getProduct_price())
                    .build();
            log.info("PRODUCTSERVICE addProducts: REQUEST TO GET ADD MULTIPLE PRODUCTS TO A PRODUCT REPOSITORY");
            productdao.save(product);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<ProductDto> deleteById(UUID productId) {
        Optional<Product> product=productdao.findById(productId);
        if(product.isPresent()){
            productdao.deleteById(productId);
            ProductDto productDto= ProductDto.builder()
                    .product_id(product.get().getProduct_id())
                    .product_name(product.get().getProduct_name())
                    .product_price(product.get().getProduct_price())
                    .build();

            log.info("PRODUCTSERVICE deleteById: REQUEST TO DELETE A PRODUCT IN PRODUCT REPOSITORY");
            return new ResponseEntity<>(productDto,HttpStatus.OK);
        }
        else{
            throw new ProductNotFoundException("Product is not found in the Database with id"+productId.toString());
        }
    }
}
