package com.prasad.ecommerce.order.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@NoArgsConstructor    
@AllArgsConstructor   
@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String orderNumber;
    
    private String customerName;
    
    @Column(nullable = false)
    private BigDecimal totalAmount;
    
    @Column(nullable = false)
    private String status; // PENDING, CONFIRMED, SHIPPED, DELIVERED
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
     
    
}
