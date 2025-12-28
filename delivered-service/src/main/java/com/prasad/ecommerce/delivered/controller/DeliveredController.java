package com.prasad.ecommerce.delivered.controller;

import com.prasad.ecommerce.delivered.entity.DeliveryStatus;
import com.prasad.ecommerce.delivered.service.DeliveredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/delivered")
public class DeliveredController {
    
    @Autowired
    private DeliveredService deliveredService;
    
    @PutMapping("/{orderId}/status/{status}")
    public ResponseEntity<DeliveryStatus> updateStatus(
            @PathVariable Long orderId,
            @PathVariable String status,
            @RequestParam String receiptId,
            @RequestParam(required = false) String notes) {
        
        DeliveryStatus statusUpdate = deliveredService.updateDeliveryStatus(
            orderId, receiptId, status, notes);
        return ResponseEntity.ok(statusUpdate);
    }
    
    @GetMapping
    public ResponseEntity<List<DeliveryStatus>> getAllStatuses() {
        return ResponseEntity.ok(deliveredService.getAllStatuses());
    }
    
    @GetMapping("/{orderId}")
    public ResponseEntity<DeliveryStatus> getStatusByOrderId(@PathVariable Long orderId) {
        Optional<DeliveryStatus> status = deliveredService.getStatusByOrderId(orderId);
        return status.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/receipt/{receiptId}")
    public ResponseEntity<DeliveryStatus> getStatusByReceiptId(@PathVariable String receiptId) {
        Optional<DeliveryStatus> status = deliveredService.getStatusByReceiptId(receiptId);
        return status.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
