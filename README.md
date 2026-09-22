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

### Payment Processing

- Payment initiation
- Payment authorization
- Payment capture
- Payment state machine
- Strategy pattern for different payment methods
- Card payment processing
- UPI payment processing
- Net banking payment processing
- Vault card integration
- Bank simulation

### Performance & Reliability

- Redis caching
- Rate limiting
- Idempotency
- Database indexes
- Auditing
- MapStruct-based entity/DTO mapping

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

## 📖 Development Approach

The project is developed incrementally.

Git commits track individual development changes, while Git tags are used to mark major milestones.



## 🔮 Planned Development

- Webhook processing
- Kafka event-driven communication
- Payment retry mechanisms
- Dead Letter Queue (DLQ)
- Settlement processing
- Advanced failure handling
- Distributed locking
- Observability
- Microservices decomposition
- API Gateway
- Performance and load testing

## ⚠️ Disclaimer

This is an educational project inspired by concepts used in real-world payment gateways. It is not affiliated with or an official implementation of Razorpay or any other payment provider.