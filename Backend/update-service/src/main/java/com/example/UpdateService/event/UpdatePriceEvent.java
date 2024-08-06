package com.example.UpdateService.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePriceEvent {
    private UUID product_id;
    private Double updated_price;
    private String msg;
}
