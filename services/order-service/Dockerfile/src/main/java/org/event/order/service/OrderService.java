/**
 * 
 */
package org.event.order.service;

import java.time.LocalDateTime;

import org.common.events.OrderCreatedEvent;
import org.event.order.dto.OrderRequest;
import org.event.order.dto.OrderResponse;
import org.event.order.repository.OrderRepository;
import org.event.order.entity.Order;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * @author Hygreva
 *
 */

@Service
@RequiredArgsConstructor
public class OrderService {

	private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate = null;
	private final OrderRepository orderRepository = null;
	private static final String TOPIC = "order-created";

	public OrderResponse createOrder(OrderRequest request) {

		/**
		 * Order order =
		 * Order.builder().productId(request.getProductId()).quantity(request.getQuantity())
		 * .price(request.getPrice()).customerId(request.getCustomerId()).status("CREATED")
		 * .createdAt(LocalDateTime.now()).build();
		 **/

		Order order = new Order(null, request.getProductId(), request.getQuantity(), request.getPrice(),
				request.getCustomerId(), "CREATED", LocalDateTime.now());

		Order savedOrder = orderRepository.save(order);

		/*
		 * OrderCreatedEvent event =
		 * OrderCreatedEvent.builder().orderId(savedOrder.getId())
		 * .productId(savedOrder.getProductId()).quantity(savedOrder.getQuantity()).
		 * price(savedOrder.getPrice()) .customerId(savedOrder.getCustomerId()).build();
		 */

		OrderCreatedEvent event = new OrderCreatedEvent(savedOrder.getId(), savedOrder.getProductId(),
				savedOrder.getQuantity(), savedOrder.getPrice(), savedOrder.getCustomerId());

		kafkaTemplate.send(TOPIC, event);

		return new OrderResponse(savedOrder.getId(), savedOrder.getStatus());
	}

}
