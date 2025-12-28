package com.prasad.ecommerce.inventory.service;

import com.prasad.ecommerce.inventory.entity.Product;
import com.prasad.ecommerce.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
    
    public Optional<Product> getProductByCode(String productCode) {
        return productRepository.findByProductCode(productCode);
    }
    
    public Product updateStock(String productCode, Integer quantity) {
        Product product = productRepository.findByProductCode(productCode)
            .orElseThrow(() -> new RuntimeException("Product not found: " + productCode));
        
        if (quantity < 0 && product.getStockQuantity() < Math.abs(quantity)) {
            throw new RuntimeException("Insufficient stock for product: " + productCode);
        }
        
        product.setStockQuantity(product.getStockQuantity() + quantity);
        return productRepository.save(product);
    }
    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
