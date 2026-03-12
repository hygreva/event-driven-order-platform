/**
 * 
 */
package org.event.inventory.consumer;


import org.common.events.OrderCreatedEvent;
import org.event.inventory.service.InventoryService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Hygreva
 *
 */
@Component
public class OrderCreatedConsumer {

	private final InventoryService inventoryService;

	public OrderCreatedConsumer(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@KafkaListener(topics = "order-created-topic", groupId = "inventory-group")
	public void consume(OrderCreatedEvent event) {

		inventoryService.reserveStock(event.getProductId(), event.getQuantity());

		System.out.println("Inventory Reserved for Order: " + event.getOrderId());
	}

}
