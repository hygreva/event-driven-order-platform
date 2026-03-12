/**
 * 
 */
package org.event.payment.service;

import org.springframework.stereotype.Service;

/**
 * @author Hygreva
 *
 */

@Service
public class PaymentService {

	public void chargePayment(String orderId, double amount) {

		// simulate payment gateway call

		System.out.println("Charging $" + amount + " for order " + orderId);
	}
}
