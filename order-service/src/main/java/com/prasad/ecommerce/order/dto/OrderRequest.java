package com.prasad.ecommerce.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor    
@AllArgsConstructor   
public class OrderRequest {
    
    @NotBlank(message = "Customer name is required")
    private String customerName; 
    
    @NotNull(message = "Total amount is required")
    @Positive(message = "Total amount must be positive")
    private BigDecimal totalAmount;
    
   
}
