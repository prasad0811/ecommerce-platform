package com.prasad.ecommerce.delivery.repository;

import com.prasad.ecommerce.delivery.entity.DeliveryAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryAssignment, Long> {
    List<DeliveryAssignment> findByOrderId(Long orderId);
    Optional<DeliveryAssignment> findByReceiptId(String receiptId);
    List<DeliveryAssignment> findByDeliveryPerson(String deliveryPerson);
}
