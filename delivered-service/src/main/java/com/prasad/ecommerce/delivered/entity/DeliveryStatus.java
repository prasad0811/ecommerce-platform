package com.prasad.ecommerce.delivered.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_status")
public class DeliveryStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long orderId;
    
    @Column(nullable = false)
    private String receiptId;
    
    @Column(nullable = false)
    private String status; // COMPLETE, INCOMPLETE
    
    private String notes;
    
    private LocalDateTime updatedAt;
    
    public DeliveryStatus() {}
    
    public DeliveryStatus(Long orderId, String receiptId, String status, String notes) {
        this.orderId = orderId;
        this.receiptId = receiptId;
        this.status = status;
        this.notes = notes;
        this.updatedAt = LocalDateTime.now();
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    
    public String getReceiptId() { return receiptId; }
    public void setReceiptId(String receiptId) { this.receiptId = receiptId; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
