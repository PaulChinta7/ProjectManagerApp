package com.example.ProductManager.event;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdatePriceEvent {
    private UUID id;
    private String msg;
    private Double price;
}
