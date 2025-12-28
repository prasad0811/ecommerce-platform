package com.prasad.ecommerce.delivered.service;

import com.prasad.ecommerce.delivered.entity.DeliveryStatus;
import com.prasad.ecommerce.delivered.repository.DeliveredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveredService {
    
    @Autowired
    private DeliveredRepository deliveredRepository;
    
    public DeliveryStatus updateDeliveryStatus(Long orderId, String receiptId, String status, String notes) {
        DeliveryStatus statusUpdate = new DeliveryStatus(orderId, receiptId, status, notes);
        return deliveredRepository.save(statusUpdate);
    }
    
    public List<DeliveryStatus> getAllStatuses() {
        return deliveredRepository.findAll();
    }
    
    public Optional<DeliveryStatus> getStatusByOrderId(Long orderId) {
        return deliveredRepository.findByOrderId(orderId).stream().findFirst();
    }
    
    public Optional<DeliveryStatus> getStatusByReceiptId(String receiptId) {
        return deliveredRepository.findByReceiptId(receiptId);
    }
}
