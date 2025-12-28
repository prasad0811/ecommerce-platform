package com.prasad.ecommerce.delivery.service;

import com.prasad.ecommerce.delivery.entity.DeliveryAssignment;
import com.prasad.ecommerce.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    
    @Autowired
    private DeliveryRepository deliveryRepository;
    
    public DeliveryAssignment assignDelivery(Long orderId, String receiptId, String deliveryPerson) {
        DeliveryAssignment assignment = new DeliveryAssignment(orderId, receiptId, deliveryPerson);
        return deliveryRepository.save(assignment);
    }
    
    public List<DeliveryAssignment> getAllDeliveries() {
        return deliveryRepository.findAll();
    }
    
    public Optional<DeliveryAssignment> getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }
    
    public Optional<DeliveryAssignment> getDeliveryByOrderId(Long orderId) {
        return deliveryRepository.findByOrderId(orderId).stream().findFirst();
    }
    
    public Optional<DeliveryAssignment> getDeliveryByReceiptId(String receiptId) {
        return deliveryRepository.findByReceiptId(receiptId);
    }
    
    public DeliveryAssignment updateStatus(Long id, String status) {
        DeliveryAssignment assignment = deliveryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Delivery not found: " + id));
        assignment.setStatus(status);
        return deliveryRepository.save(assignment);
    }
    
    public List<DeliveryAssignment> getDeliveriesByPerson(String deliveryPerson) {
        return deliveryRepository.findByDeliveryPerson(deliveryPerson);
    }
}
