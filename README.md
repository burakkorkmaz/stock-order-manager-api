# Stock Order Manager API

This project is a backend API for a brokerage firm that allows employees to create, list, and cancel stock orders for customers. It also supports deposit and withdrawal operations for customer accounts. The API is built using Java 17 and Spring Boot 3.3.4.

## Requirements

- Java 17.0.11 or higher
- Maven
- Spring Boot 3.3.4
- H2 Database

## Getting Started

### 1. Clone the Project

```bash
git clone https://github.com/stock-order-manager-api/stock-order-manager-api.git
cd stock-order-manager-api
```

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

### 4. Access the H2 Database Console

The project uses an H2 in-memory database. You can access the H2 console via:

- URL: `http://localhost:8092/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: *(leave empty)*

## API Endpoints

- **POST** `/order/create`: Create a new stock order
- **POST** `/order/list`: List orders for a customer
- **DELETE** `/order/delete/{id}`: Cancel a pending order
- **POST** `/customer/deposit`: Deposit money to a customer account
- **POST** `/customer/withdraw`: Withdraw money from a customer account
- **GET**  `/asset/list/{id}`: List all assets for a given customer
