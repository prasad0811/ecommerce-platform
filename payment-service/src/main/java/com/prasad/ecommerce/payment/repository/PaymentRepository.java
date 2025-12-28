package com.prasad.ecommerce.payment.repository;
import  com.prasad.ecommerce.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByReceiptId(String receiptId);
    Optional<Payment> findByOrderId(Long orderId);
}