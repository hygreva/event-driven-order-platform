/**
 * 
 */
package org.event.order.controller;

import org.event.order.dto.OrderRequest;
import org.event.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Hygreva
 *
 */

@Slf4j
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService = new OrderService();
	// Obtain a logger instance for the current class
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);

	/*
	 * public OrderController(OrderService orderService) { this.orderService =
	 * orderService; }
	 */

	@PostMapping
	public ResponseEntity<String> createOrder(@Valid @RequestBody OrderRequest request) {

		log.info("Creating order");
		log.debug("Saving order to database");
		orderService.createOrder(request);

		return ResponseEntity.ok("Order created");
	}
}
