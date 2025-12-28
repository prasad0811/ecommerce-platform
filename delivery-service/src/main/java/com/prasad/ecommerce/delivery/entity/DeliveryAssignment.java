package com.prasad.ecommerce.delivery.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_assignments")
public class DeliveryAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long orderId;
    
    @Column(nullable = false)
    private String receiptId;
    
    @Column(nullable = false)
    private String deliveryPerson;
    
    @Column(nullable = false)
    private String status; // ASSIGNED, IN_TRANSIT, DELIVERED, FAILED
    
    private LocalDateTime assignedAt;
    
    public DeliveryAssignment() {}
    
    public DeliveryAssignment(Long orderId, String receiptId, String deliveryPerson) {
        this.orderId = orderId;
        this.receiptId = receiptId;
        this.deliveryPerson = deliveryPerson;
        this.status = "ASSIGNED";
        this.assignedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    
    public String getReceiptId() { return receiptId; }
    public void setReceiptId(String receiptId) { this.receiptId = receiptId; }
    
    public String getDeliveryPerson() { return deliveryPerson; }
    public void setDeliveryPerson(String deliveryPerson) { this.deliveryPerson = deliveryPerson; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = status; 
    }
    
    public LocalDateTime getAssignedAt() { return assignedAt; }
    public void setAssignedAt(LocalDateTime assignedAt) { this.assignedAt =assignedAt;}
}
