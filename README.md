# 💰 Finance Dashboard Backend

## 📌 Overview

This project is a backend system for a finance dashboard that enables users to manage financial records and view analytics based on role-based access control.

It demonstrates clean backend architecture, structured API design, and secure access handling.

---

## 🛠 Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* PostgreSQL
* Maven

---

## 🧩 Features

### 👤 User Management

* Create users
* Assign roles (ADMIN, ANALYST, VIEWER)
* Activate/Deactivate users

---

### 💳 Financial Records

* Create, update, delete financial entries
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

### 🔐 Role-Based Access Control (RBAC)

| Role    | Access           |
| ------- | ---------------- |
| ADMIN   | Full access      |
| ANALYST | Read + dashboard |
| VIEWER  | Read-only        |

Implemented using:

* Spring Security
* `@PreAuthorize`
* Custom filter (header-based role simulation)

---

### ✅ Validation & Error Handling

* Input validation using annotations
* Global exception handler
* Structured error responses

---

## 🔌 API Endpoints

### Users

* POST `/users`
* GET `/users`
* PATCH `/users/{id}/status`

---

### Financial Records

* POST `/records`
* GET `/records`
* PUT `/records/{id}`
* DELETE `/records/{id}`

---

### Dashboard

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

## ▶️ Running the Project

1. Clone repo
2. Configure PostgreSQL in `application.yml`
3. Run application

---

## 🧠 Design Decisions

* Used layered architecture (Controller → Service → Repository)
* DTOs for request/response separation
* RBAC implemented at service layer
* Database constraints for data integrity

---

## 🚀 Future Improvements

* JWT authentication
* Pagination & filtering
* Swagger API documentation
* Category-wise analytics

---

## ⭐ Key Highlights

* Clean, maintainable code structure
* Strong separation of concerns
* Extensible security design
* Production-like backend approach
