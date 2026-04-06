# 💰 Finance Dashboard Backend

## 📌 Overview

This project is a backend system for a finance dashboard that allows users to manage financial records and view analytics based on role-based access control (RBAC).

It demonstrates backend engineering fundamentals including API design, data modeling, access control, validation, and clean architecture.

---

## 🛠 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* PostgreSQL
* Maven

---

## 🏗️ Architecture

The application follows a layered architecture:

**Controller → Service → Repository → Database**

* **Controller**: Handles HTTP requests and responses
* **Service**: Contains business logic and access control
* **Repository**: Manages database operations using JPA
* **Database**: Stores persistent data (PostgreSQL)

---

## 🔄 Request Flow

1. Client sends HTTP request
2. Controller receives and validates request
3. Service processes business logic and enforces RBAC
4. Repository interacts with database
5. Response is returned to client

---

## 🧩 Features

### 👤 User Management

* Create users
* Assign roles (ADMIN, ANALYST, VIEWER)
* Activate / deactivate users

---

### 💳 Financial Records

* Create, update, delete financial records
* Fields:

    * Amount
    * Type (INCOME / EXPENSE)
    * Category
    * Date
    * Description

---

### 📊 Dashboard APIs

* Total Income
* Total Expense
* Net Balance

---

## 🔐 Role-Based Access Control (RBAC)

| Role    | Permissions                          |
| ------- | ------------------------------------ |
| ADMIN   | Full access (CRUD + user management) |
| ANALYST | Read + dashboard access              |
| VIEWER  | Read-only                            |

### Implementation Details

* Spring Security enforced at the filter chain level (SecurityFilterChain)
* Custom filter to simulate roles via request headers
* Designed to be easily extendable to JWT-based authentication

---

## 🔑 Testing RBAC

Since authentication is simplified, roles can be passed using request headers:

```plaintext
X-ROLE: ADMIN
X-ROLE: ANALYST
X-ROLE: VIEWER
```

---

## 🔌 API Endpoints

### 👤 Users

* POST `/users` → Create user
* GET `/users` → Get all users
* PATCH `/users/{id}/status` → Update user status

---

### 💰 Financial Records

* POST `/records`
* GET `/records`
* PUT `/records/{id}`
* DELETE `/records/{id}`

---

### 📊 Dashboard

* GET `/dashboard/summary`

---

## 📥 Sample Request

### Create User

```json
{
  "name": "Anu",
  "email": "anu@test.com",
  "password": "1234",
  "role": "ADMIN"
}
```

---

## ⚠️ Sample Error Response

```json
{
  "error": "Email already exists"
}
```

---

## ▶️ Running the Project

### Prerequisites
- Java 17
- Maven
- PostgreSQL

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/annubelgaonkar/finance-app.git
cd finance-app
```

**2. Create the database**
```sql
CREATE DATABASE finance_db;
```

**3. Configure `application.yml`**
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/finance_db
    username: <your_username>
    password: <your_password>
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

**4. Run the application**
```bash
mvn spring-boot:run
```

**5. App runs at:** `http://localhost:8080`

### Testing the API

Pass roles via request header:
```bash
curl -X POST http://localhost:8080/users \
  -H "Content-Type: application/json" \
  -H "X-ROLE: ADMIN" \
  -d '{"name": "Anu", "email": "anu@test.com", "password": "1234", "role": "ADMIN"}'
```


## 🧠 Design Decisions

* Used layered architecture for separation of concerns
* DTOs used to decouple API from database entities
* RBAC implemented at the security filter chain level, ensuring authorization before request validation
* Database constraints used to ensure data integrity

---

## 🚀 Future Improvements

* JWT-based authentication
* Pagination and filtering
* Swagger/OpenAPI documentation
* Category-wise analytics

---

## ⭐ Key Highlights

* Clean and maintainable code structure
* Proper separation of concerns
* Production-style backend design
* Extensible security implementation

---
