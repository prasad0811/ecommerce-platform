package com.prasad.ecommerce.order.controller;

import com.prasad.ecommerce.order.dto.OrderRequest;
import com.prasad.ecommerce.order.entity.Order;
import com.prasad.ecommerce.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderRequest request) {
		Order order = orderService.createOrder(request);
		return ResponseEntity.ok(order);
	}

	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		return ResponseEntity.ok(orderService.getAllOrders());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrder(@PathVariable Long id) {
		Optional<Order> order = orderService.getOrderById(id);
		return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/number/{orderNumber}")
	public ResponseEntity<Order> getOrderByNumber(@PathVariable String orderNumber) {
		Optional<Order> order = orderService.getOrderByNumber(orderNumber);
		return order.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}/status/{status}")
	public ResponseEntity<Order> updateStatus(@PathVariable Long id, @PathVariable String status) {
		Order order = orderService.updateOrderStatus(id, status);
		return ResponseEntity.ok(order);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return ResponseEntity.noContent().build();
	}
}
