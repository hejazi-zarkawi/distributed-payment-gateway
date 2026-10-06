# Distributed Payment Gateway

A distributed payment gateway system built with Java and Spring Boot, inspired by real-world payment platforms.

The primary goal of this project is to understand and implement the core concepts behind a reliable, scalable, and distributed payment processing system.

## 🚧 Project Status

**Active Development**

The system is currently being developed as a modular monolithic application, with the architecture designed to evolve toward microservices.

## 🎯 Goals

This project focuses on implementing concepts commonly required in a reliable payment processing system:

- Payment processing
- Merchant management
- Order management
- Concurrency handling
- Idempotency
- Distributed transactions
- T+1 settlement processing
- Event-driven architecture
- Webhook-based notifications
- Redis caching
- Apache Kafka
- Fault tolerance
- Retry mechanisms
- Database consistency
- Rate limiting
- Authentication & authorization
- Scalability
- Observability
- Monolith-to-microservices evolution

## ✅ Implemented Features

### Merchant & Authentication

- Merchant signup
- JWT-based authentication
- Merchant login
- API key generation
- API key rotation
- API key revocation
- API key authentication filter
- Auditor-aware implementation

### Order Management

- Create order
- Get order by ID
- Get all orders
- Get payments associated with an order
- Cancel order
- Order idempotency
- Order rate limiting
- Customer ID integration
- Redis caching
- Transaction management
- Pessimistic locking

### Payment Processing

- Payment initiation
- Payment authorization
- Payment capture
- Payment state machine
- Payment transition service
- Strategy Pattern for payment methods
- Card payment processing
- UPI payment processing
- Net banking payment processing
- Vault card integration
- Card tokenization
- Customer integration
- Bank simulation
- Transaction management
- Pessimistic locking

### Webhook Processing

- Kafka-based webhook event consumption
- Webhook event persistence
- Redis-based event queuing
- Scheduler-based webhook processing
- Webhook delivery to merchant servers
- Merchant response handling
- Webhook delivery status tracking
- Failed webhook retry mechanism
- Database polling for pending webhook events

### Event-Driven Architecture

- Apache Kafka producer and consumer
- Transactional Outbox Pattern
- Kafka-based asynchronous event processing
- Webhook event propagation
- Redis-backed event queue
- Scheduler-based event processing

### Reliability & Fault Tolerance

- Idempotency
- Rate limiting
- Redis caching
- Transaction management
- Pessimistic locking
- Transactional Outbox Pattern
- Webhook retry mechanism
- Failed-event recovery through database polling
- Dead Letter Queue support

### Settlement

- T+1 payment settlement
- Settlement payment tracking
- Merchant settlement processing
- Settlement state management

### Performance

- Redis caching
- API rate limiting
- Database indexes

### Consistency & Concurrency

- Transaction management
- Pessimistic locking
- Idempotency
- Database auditing
- Customer/order/payment consistency

### Reliability

- Transactional Outbox Pattern
- Kafka asynchronous processing
- Webhook retry mechanism
- Failed-event recovery through database polling

## 🛠️ Tech Stack

- **Java**
- **Spring Boot**
- **Maven**
- **PostgreSQL**
- **Redis**
- **Apache Kafka**
- **Docker**
- **Git & GitHub**

Additional technologies will be introduced as the project evolves.

## 📁 Project Structure

```text
src/main/java/
└── com/mohammad/distributedpaymentgateway/
    ├── common/
    │   └── enums/
    │
    ├── merchant/
    │
    ├── payment/
    │
    ├── operations/
    │
    └── vault/
```
The project is organized around **business/domain areas** rather than global technical layers.

## 🏗️ Architecture

The project is currently being developed as a **modular monolith**.

The long-term architecture will evolve toward a **distributed microservices architecture**.

Architecture diagrams, service boundaries, payment flows, and event flows will be documented as the system evolves.

## 🔄 Payment Flow

```text
Client
  ↓
Order Creation
  ↓
Payment Initiation
  ↓
Payment Authorization
  ↓
Payment Capture
  ↓
Outbox Event
  ↓
Kafka
  ↓
Webhook Event
  ↓
Redis Queue
  ↓
Webhook Scheduler
  ↓
Merchant Server
  ↓
Webhook Delivered
  ↓
T+1 Settlement
  ↓
Merchant Account
```

## 📖 Development Approach

The project is developed incrementally.

Git commits track individual development changes, while Git tags are used to mark major milestones.



## 🔮 Planned Development

- Advanced failure handling
- Distributed locking
- Observability
- API Gateway
- Microservices decomposition
- Service discovery
- Centralized configuration
- Performance and load testing
- Distributed tracing

## ⚠️ Disclaimer

This is an educational project inspired by concepts used in real-world payment gateways. It is not affiliated with or an official implementation of Razorpay or any other payment provider.