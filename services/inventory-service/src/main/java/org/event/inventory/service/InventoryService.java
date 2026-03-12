/**
 * 
 */
package org.event.inventory.service;

import org.springframework.stereotype.Service;

/**
 * @author Hygreva
 *
 */

@Service
public class InventoryService {

	public void reserveStock(String productId, int quantity) {

		// In real system update DB

		System.out.println("Reserving " + quantity + " items for product " + productId);
	}

}
