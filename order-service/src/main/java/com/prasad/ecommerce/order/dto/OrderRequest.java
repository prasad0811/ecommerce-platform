package com.prasad.ecommerce.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class OrderRequest {

	@NotBlank(message = "Customer name is required")
	private String customerName;

	@NotNull(message = "Total amount is required")
	@Positive(message = "Total amount must be positive")
	private BigDecimal totalAmount;

	// Constructors
	public OrderRequest() {
	}

	public OrderRequest(String customerName, BigDecimal totalAmount) {
		this.customerName = customerName;
		this.totalAmount = totalAmount;
	}

	// Getters and Setters
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
}
