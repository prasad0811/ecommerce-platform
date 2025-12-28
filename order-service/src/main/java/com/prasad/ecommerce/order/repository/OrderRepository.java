package com.prasad.ecommerce.order.repository;

import com.prasad.ecommerce.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    List<Order> findByCustomerName(String customerName);
    
    Optional<Order> findByOrderNumber(String orderNumber);
}
