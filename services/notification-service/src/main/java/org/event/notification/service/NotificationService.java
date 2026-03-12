package org.event.notification.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	public void sendEmail(String email, String orderId) {

		System.out.println("Sending email to " + email + " for order " + orderId);
	}
}
