/**
 * 
 */
package org.event.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Hygreva
 *
 */

@Data
public class OrderResponse {

	public OrderResponse(String id, String status2) {
		this.orderId = id;
		this.status = status2;
	}

	private String orderId;
	private String status;

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
