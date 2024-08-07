package com.example.ProductManager.exception;


import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    int status;
    String msg;
    
}
