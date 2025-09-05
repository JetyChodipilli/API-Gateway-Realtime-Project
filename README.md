# 🛒 E-Commerce Microservices with Spring Boot and Spring Cloud

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-green.svg)
![Spring Cloud](https://img.shields.io/badge/SpringCloud-Eureka%20%26%20Gateway-orange.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

## 📖 Overview

This project implements a real-time e-commerce application using a **microservices architecture** with Spring Boot and Spring Cloud. It consists of multiple services that manage product information, customer orders, and inventory. Service discovery and routing are handled by **Eureka Server** and an **API Gateway**.

The application demonstrates a scalable, modular approach to building modern web applications. APIs are tested using **Postman**.

---

## 🧩 Microservices

- **Product Service**: Manages product details, pricing, and availability  
- **Order Service**: Handles customer orders, status updates, and order management  
- **Inventory Service**: Tracks and updates product stock levels  
- **Eureka Server**: Enables service discovery and registration  
- **API Gateway**: Routes incoming requests to appropriate microservices

---

## 🏗️ Architecture

```text
Postman Client → API Gateway → Eureka Server → Microservices
```

- **Postman**: Sends HTTP requests to the API Gateway  
- **API Gateway**: Uses Spring Cloud Gateway to route requests  
- **Eureka Server**: Acts as a registry for all services  
- **Microservices**: Communicate via REST APIs and register with Eureka

---

## 🧰 Technologies Used

- **Language**: Java 17  
- **Framework**: Spring Boot 3.x  
- **Microservices Tools**: Spring Cloud (Eureka, Gateway)  
- **Build Tool**: Maven  
- **Testing Tool**: Postman  
- **Dependencies**: Spring Web, Spring Data JPA, Spring Cloud Netflix Eureka, Spring Cloud Gateway, Lombok

---

## 📁 Project Structure

```text
ecommerce-microservices/
├── api-gateway/                 # API Gateway service
│   ├── src/main/java/com/ccp/
│   │   └── ApiGatewayApplication.java
│   └── pom.xml
├── eureka-server/              # Eureka Server
│   ├── src/main/java/com/ccp/
│   │   └── EurekaServerApplication.java
│   └── pom.xml
├── product-service/            # Product Service
│   ├── src/main/java/com/ccp/
│   │   └── ProductServiceApplication.java
│   └── pom.xml
├── order-service/              # Order Service
│   ├── src/main/java/com/ccp/
│   │   └── OrderServiceApplication.java
│   └── pom.xml
├── inventory-service/          # Inventory Service
│   ├── src/main/java/com/ccp/
│   │   └── InventoryServiceApplication.java
│   └── pom.xml
├── assets/                     # Images for README (e.g., logo, diagrams)
└── README.md                   # Project documentation
```

---

## 🛠️ Prerequisites

- Java 17 or higher  
- Maven 3.6+  
- Postman for API testing  
- *(Optional)* Docker for containerized deployment  
- A running database (e.g., MySQL or PostgreSQL) for Product, Order, and Inventory Services

---

## ⚙️ Setup Instructions

### 📥 Clone the Repository

```bash
git clone <repository-url>
cd ecommerce-microservices
```

### 🛢️ Configure Database

Set up a database (e.g., MySQL) for each service. Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<service_db>
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.jpa.hibernate.ddl-auto=update
```

### 🏗️ Build All Services

Navigate to each service directory and run:

```bash
mvn clean install
```

### ▶️ Run the Services

Start Eureka Server:

```bash
cd eureka-server
mvn spring-boot:run
```

Start API Gateway:

```bash
cd ../api-gateway
mvn spring-boot:run
```

Start Product, Order, and Inventory Services:

```bash
cd ../product-service
mvn spring-boot:run

cd ../order-service
mvn spring-boot:run

cd ../inventory-service
mvn spring-boot:run
```

---

## 🔍 Verify Eureka Server

Open [http://localhost:8761](http://localhost:8761) to view the Eureka dashboard and confirm all services are registered.

---

## 📡 Usage

### 🔧 Test APIs with Postman

- **API Gateway URL**: `http://localhost:8080`

#### Example Requests

- **Get Products**  
  `GET http://localhost:8080/api/products`

- **Create Order**  
  `POST http://localhost:8080/api/orders`

```json
{
  "productId": 1,
  "quantity": 2,
  "customerId": 101
}
```

- **Check Inventory**  
  `GET http://localhost:8080/api/inventory?productId=1`

> Import the Postman collection (if provided) for pre-configured requests.

---

## 🔄 Service Communication

- API Gateway routes requests based on URL paths  
- Services communicate via REST APIs  
- Eureka enables dynamic service discovery

---

## 📊 Monitoring

- Use [http://localhost:8761](http://localhost:8761) to monitor services  
- Check logs for debugging and health checks

---

## 📌 Sample API Endpoints

### 🛍️ Product Service

- `GET /api/products` — List all products  
- `POST /api/products` — Create a new product

```json
{
  "name": "Laptop",
  "price": 999.99,
  "description": "High-performance laptop"
}
```

### 📦 Order Service

- `POST /api/orders` — Create an order  
- `GET /api/orders/{id}` — Get order details

### 🏬 Inventory Service

- `GET /api/inventory?productId={id}` — Check stock  
- `PUT /api/inventory` — Update stock

```json
{
  "productId": 1,
  "quantity": 50
}
```

---

## 🧭 Architecture Diagram

> *(Add your architecture diagram image to `assets/` and embed it here using Markdown)*

---

## 📝 Notes

- Start Eureka Server before other services  
- Use separate databases for each microservice  
- Customize routing in `api-gateway/src/main/resources/application.yml`  
- Scale services independently by running multiple instances

---

## 🛠️ Troubleshooting

| Issue                 | Solution                                                                 |
|----------------------|--------------------------------------------------------------------------|
| Service Not Registered| Ensure Eureka is running at `http://localhost:8761`                     |
| API Gateway Errors    | Check routing config in `application.yml`                               |
| Database Issues       | Verify credentials and connectivity in `application.properties`         |
| README Wrapping       | Use LF line endings and proper Markdown formatting                      |

```bash
sed -i 's/\r$//' README.md
git add README.md
git commit -m "Fix line endings"
git push origin main
```

---

## 🚀 Future Enhancements

- Add user management service (authentication & authorization)  
- Integrate payment processing (e.g., Stripe API)  
- Implement circuit breakers with Resilience4j  
- Deploy with Docker & Kubernetes  
- Add monitoring with Spring Boot Actuator & Prometheus

---

## 🤝 Contributing

Contributions are welcome! Submit pull requests or open issues for bugs, improvements, or new features.

---

## 📜 License

This project is licensed under the **MIT License**.
