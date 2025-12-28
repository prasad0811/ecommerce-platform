// payment-service/src/main/java/com/prasad/ecommerce/payment/entity/Payment.java
package com.prasad.ecommerce.payment.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String receiptId;
    
    @Column(nullable = false)
    private Long orderId;
    
    @Column(nullable = false)
    private BigDecimal amount;
    
    @Column(nullable = false)
    private String paymentMethod; // UPI, CASH
    
    private String upiQrData; // For UPI: "orderId:amount"
    
    @Column(nullable = false)
    private LocalDateTime paymentDate;
    
    @Column(nullable = false)
    private String status; // COMPLETED, FAILED
    
    public Payment() {}
    
    // Constructor for UPI
    public Payment(Long orderId, BigDecimal amount, String upiQrData) {
        this.receiptId = "RCPT-" + System.currentTimeMillis();
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = "UPI";
        this.upiQrData = upiQrData;
        this.paymentDate = LocalDateTime.now();
        this.status = "COMPLETED";
    }
    
    // Constructor for Cash
    public Payment(Long orderId, BigDecimal amount) {
        this.receiptId = "RCPT-" + System.currentTimeMillis();
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = "CASH";
        this.paymentDate = LocalDateTime.now();
        this.status = "COMPLETED";
    }
    
    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReceiptId() { return receiptId; }
    public void setReceiptId(String receiptId) { this.receiptId = receiptId; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getUpiQrData() { return upiQrData; }
    public void setUpiQrData(String upiQrData) { this.upiQrData = upiQrData; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
