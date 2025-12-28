package com.prasad.ecommerce.delivered.repository;

import com.prasad.ecommerce.delivered.entity.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveredRepository extends JpaRepository<DeliveryStatus, Long> {
    List<DeliveryStatus> findByOrderId(Long orderId);
    Optional<DeliveryStatus> findByReceiptId(String receiptId);
}
