/**
 * 
 */
package org.event.payment.consumer;

import org.common.events.OrderCreatedEvent;
import org.event.payment.service.PaymentService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Hygreva
 *
 */

@Component
public class PaymentConsumer {

	private final PaymentService paymentService;

	public PaymentConsumer(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@KafkaListener(topics = "order-created-topic", groupId = "payment-group")
	public void processPayment(OrderCreatedEvent event) {

		paymentService.chargePayment(event.getOrderId(), event.getPrice());

		System.out.println("Payment processed for order " + event.getOrderId());
	}
}
