// payment-service/src/main/java/com/prasad/ecommerce/payment/dto/PaymentRequest.java
package com.prasad.ecommerce.payment.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class PaymentRequest {
    @NotNull private Long orderId;
    @NotNull @Positive private BigDecimal amount;
    private String paymentMethod; // UPI, CASH
    
    // Constructors, Getters, Setters
    public PaymentRequest() {}
    public PaymentRequest(Long orderId, BigDecimal amount, String paymentMethod) {
        this.orderId = orderId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }
    
    public Long getOrderId()
    {
    	return orderId;
    }
    public BigDecimal getAmount()
    {
    	return amount;
    }
    public String getPaymentMethod ()
    {
    	return paymentMethod;
    }
    public void setOrderId(Long orderId)
    {
    	this.orderId = orderId;
    }
   public void setAmount (BigDecimal amount)
   {
	   this.amount = amount;
	   
   }
   public void setPaymentMethod(String paymentMethod )
   {
	   this.paymentMethod= paymentMethod;
   }
}
