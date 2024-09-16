---

# **Order Management System**

This project is a simple Order Management System built with Spring Boot, H2 Database, and JUnit 5 for testing. The system provides RESTful endpoints to perform CRUD operations (Create, Read, Update, and Delete) on orders.

---

## **Getting Started**

### **Prerequisites**
To run the application locally, make sure you have:
- Java 17 installed
- Maven installed

### **Installation Steps**
1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd order-management-system
   ```

2. Build the project using Maven:

   ```bash
   mvn clean install
   ```

3. Run the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

---

## **Application Overview**

### **Tech Stack**
- **Java 17**
- **Spring Boot 3.3.3**
- **Spring Data JPA** for database interactions
- **H2 Database** as an in-memory database
- **JUnit 5** for testing
- **Lombok** for reducing boilerplate code

### **Features**
- Create, retrieve, update, and delete orders.
- H2 in-memory database for quick setup.
- JUnit 5 for thorough unit testing.

---

## **Postman Testing**

### **1. Create an Order**

**Endpoint**: `/orders`

**Method**: `POST`

**Request Body**:

```json
{
  "productName": "Laptop",
  "quantity": 1,
  "customerName": "John Doe",
  "orderDate": "2024-09-16"
}
```

**Response**:

```json
{
  "id": 1,
  "productName": "Laptop",
  "quantity": 1,
  "customerName": "John Doe",
  "orderDate": "2024-09-16"
}
```

### **2. Get All Orders**

**Endpoint**: `/orders`

**Method**: `GET`

**Response**:

```json
[
  {
    "id": 1,
    "productName": "Laptop",
    "quantity": 1,
    "customerName": "John Doe",
    "orderDate": "2024-09-16"
  }
]
```

### **3. Get Order By ID**

**Endpoint**: `/orders/{id}`

**Method**: `GET`

Example:

```http
GET /orders/1
```

**Response**:

```json
{
  "id": 1,
  "productName": "Laptop",
  "quantity": 1,
  "customerName": "John Doe",
  "orderDate": "2024-09-16"
}
```

### **4. Update an Order**

**Endpoint**: `/orders/{id}`

**Method**: `PUT`

**Request Body**:

```json
{
  "productName": "Keyboard",
  "quantity": 3,
  "customerName": "Jane Doe",
  "orderDate": "2024-09-18"
}
```

**Response**:

```json
{
  "id": 1,
  "productName": "Keyboard",
  "quantity": 3,
  "customerName": "Jane Doe",
  "orderDate": "2024-09-18"
}
```

### **5. Delete an Order**

**Endpoint**: `/orders/{id}`

**Method**: `DELETE`

Example:

```http
DELETE /orders/1
```

**Response**: `200 OK`

---

## **Unit Testing**

This project includes unit tests written with JUnit 5 for key functionalities. The following cases have been tested:
1. **Creating an Order** — Verifying that an order is saved with the correct details.
2. **Fetching Orders** — Testing whether the correct order is returned by its ID.
3. **Edge Case** — Testing when an order is not found, ensuring the system returns null appropriately.

### **Running the Tests**
To run all tests:

```bash
mvn test
```

---

## **Database Configuration**

The application uses the H2 in-memory database by default. You can view the database console by navigating to the following URL while the application is running:

```
http://localhost:8080/h2-console
```

Use the following settings to log in:

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

---

## **License**

This project is licensed under the MIT License - see the LICENSE file for details.

---
