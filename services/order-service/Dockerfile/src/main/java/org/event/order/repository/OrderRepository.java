/**
 * 
 */
package org.event.order.repository;

import org.event.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hygreva
 *
 */

public interface OrderRepository extends JpaRepository<Order, String> {
}
