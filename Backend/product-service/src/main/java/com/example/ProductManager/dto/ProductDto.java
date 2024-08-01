package com.example.ProductManager.dto;

import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private UUID product_id;
    private String product_name;
    private double product_price;

}
