package com.example.ProductManager.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="Products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID product_id;
    private String product_name;
    private double product_price;
}
