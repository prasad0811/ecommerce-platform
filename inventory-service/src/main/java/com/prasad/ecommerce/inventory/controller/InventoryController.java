package com.prasad.ecommerce.inventory.controller;

import com.prasad.ecommerce.inventory.entity.Product;
import com.prasad.ecommerce.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class InventoryController {
    
    @Autowired
    private InventoryService inventoryService;
    
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = inventoryService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }
    
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(inventoryService.getAllProducts());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<Product> product = inventoryService.getProductById(id);
        return product.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/code/{productCode}")
    public ResponseEntity<Product> getProductByCode(@PathVariable String productCode) {
        Optional<Product> product = inventoryService.getProductByCode(productCode);
        return product.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/code/{productCode}/stock/{quantity}")
    public ResponseEntity<Product> updateStock(@PathVariable String productCode, 
                                             @PathVariable Integer quantity) {
        Product product = inventoryService.updateStock(productCode, quantity);
        return ResponseEntity.ok(product);
    }
}
