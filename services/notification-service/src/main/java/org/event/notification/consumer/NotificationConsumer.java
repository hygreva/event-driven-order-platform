/**
 * 
 */
package org.event.notification.consumer;

import org.common.events.OrderCreatedEvent;
import org.event.notification.service.NotificationService;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Hygreva
 *
 */

@Component
public class NotificationConsumer {

	private final NotificationService notificationService;

	public NotificationConsumer(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@KafkaListener(topics = "order-created-topic", groupId = "notification-group")
	public void consume(OrderCreatedEvent event) {

		notificationService.sendEmail(event.getUserEmail(), event.getOrderId());
	}

}
