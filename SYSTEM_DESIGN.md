## Architecture Style
Event Driven Microservices Architecture.
Services communicate asynchronously using Kafka topics.

## Key Components
Order Service
Receives client order requests and publishes OrderCreated events.

Inventory Service
Reserves product inventory when order event received.

Payment Service
Processes payment simulation.

Notification Service
Sends order confirmation notifications.

## Event Flow
OrderCreated
→ InventoryReserved
→ PaymentProcessed
→ OrderCompleted

## Scalability
Each service can scale independently using container orchestration.
Kafka partitions allow horizontal event processing.

## Reliability Patterns
Retry queues
Dead letter queues
Idempotent event handling

## Tradeoffs
Event-driven systems introduce eventual consistency but improve scalability and fault isolation.
