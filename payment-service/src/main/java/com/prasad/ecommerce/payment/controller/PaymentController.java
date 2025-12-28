package com.prasad.ecommerce.payment.controller;
import  com.prasad.ecommerce.payment.dto.PaymentRequest;
import  com.prasad.ecommerce.payment.service.PaymentService;
import com.prasad.ecommerce.payment.entity.Payment;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired private PaymentService service;
    
    @PostMapping("/upi")
    public ResponseEntity<Payment> payByUpi(@Valid @RequestBody PaymentRequest request) {
        Payment payment = service.processUpiPayment(request.getOrderId(), request.getAmount());
        return ResponseEntity.ok(payment);
    }
    
    @PostMapping("/cash")
    public ResponseEntity<Payment> payByCash(@Valid @RequestBody PaymentRequest request) {
        Payment payment = service.processCashPayment(request.getOrderId(), request.getAmount());
        return ResponseEntity.ok(payment);
    }
}
