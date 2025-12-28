package com.prasad.ecommerce.delivery.controller;

import com.prasad.ecommerce.delivery.entity.DeliveryAssignment;
import com.prasad.ecommerce.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    
    @Autowired
    private DeliveryService deliveryService;
    
    @PostMapping
    public ResponseEntity<DeliveryAssignment> assignDelivery(
            @RequestParam Long orderId,
            @RequestParam String receiptId,
            @RequestParam String deliveryPerson) {
        DeliveryAssignment assignment = deliveryService.assignDelivery(orderId, receiptId, deliveryPerson);
        return ResponseEntity.ok(assignment);
    }
    
    @GetMapping
    public ResponseEntity<List<DeliveryAssignment>> getAllDeliveries() {
        return ResponseEntity.ok(deliveryService.getAllDeliveries());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DeliveryAssignment> getDelivery(@PathVariable Long id) {
        Optional<DeliveryAssignment> assignment = deliveryService.getDeliveryById(id);
        return assignment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/track/{orderId}")
    public ResponseEntity<DeliveryAssignment> trackDelivery(@PathVariable Long orderId) {
        Optional<DeliveryAssignment> assignment = deliveryService.getDeliveryByOrderId(orderId);
        return assignment.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/person/{deliveryPerson}")
    public ResponseEntity<List<DeliveryAssignment>> getPersonDeliveries(@PathVariable String deliveryPerson) {
        return ResponseEntity.ok(deliveryService.getDeliveriesByPerson(deliveryPerson));
    }
    
    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<DeliveryAssignment> updateStatus(@PathVariable Long id, @PathVariable String status) {
        DeliveryAssignment assignment = deliveryService.updateStatus(id, status);
        return ResponseEntity.ok(assignment);
    }
}
