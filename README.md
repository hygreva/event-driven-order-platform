# Event Driven Order Processing Platform
This project demonstrates a scalable distributed microservices architecture using event-driven design.
The system simulates a modern e-commerce backend capable of processing high-volume orders using asynchronous messaging.

## Architecture Overview
The platform uses event-driven communication between services using Kafka.
Client → API Gateway → Order Service → Kafka Events

Services:
- Order Service
- Inventory Service
- Payment Service
- Notification Service

## Technology Stack

Backend
- Java
- Spring Boot

Messaging
- Apache Kafka

Infrastructure
- Docker
- Kubernetes
- Terraform

Observability
- Prometheus
- Grafana

Database
- PostgreSQL

## Architecture Diagram

(Insert architecture diagram)

## Key Design Concepts

- Event Driven Architecture
- Asynchronous Processing
- Microservices
- Distributed System Reliability
- Horizontal Scalability

## Running the System

```bash
docker-compose up
