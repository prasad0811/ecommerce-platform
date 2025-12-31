# E-Commerce Microservices Platform

This project implements a complete e-commerce backend as 5 independent microservices connected through an API Gateway. Users can browse products, place orders, process payments, assign deliveries, and track status end to end.This Spring Boot project is a RESTful web service designed for E-Commerce Platform. It demonstrates core Spring Boot concepts including REST APIs, JPA, and integration with PgSQL database.

##Microservices Architecture (5 Services)

- Order Service - Creates and manages orders (PENDING → CONFIRMED).

- Inventory Service - Product catalog and real-time stock management.

- Payment Service - Make Payments and Generates receipts.

- Delivery Service - Assigns delivery personnel and tracking.

- Delivered Service - Final delivery status updates (COMPLETE/INCOMPLETE).

- API Gateway - Single entry point routing requests to services.

 ##Technology Stack 

 - Spring Boot 3.2 - Industry-standard Java framework for REST APIs and microservices

 - PostgreSQL 15 - ACID-compliant relational database for order/payment consistency

 - Docker Compose - Orchestrates 7 containers (DB + 5 services).

