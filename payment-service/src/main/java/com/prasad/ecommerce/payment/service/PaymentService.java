package com.prasad.ecommerce.payment.service;
import java.math.BigDecimal;
import com.prasad.ecommerce.payment.entity.Payment;
import com.prasad.ecommerce.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    
	@Autowired 
    private PaymentRepository repository;
    
    public Payment processUpiPayment(Long orderId, BigDecimal amount) {
        String qrData = "orderId:" + orderId + ":amount:" + amount;
        return repository.save(new Payment(orderId, amount, qrData));
    }
    
    public Payment processCashPayment(Long orderId, BigDecimal amount) {
        return repository.save(new Payment(orderId, amount));
    }
}