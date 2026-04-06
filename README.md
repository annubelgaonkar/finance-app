# Finance Dashboard Backend

## Overview

This project is a backend system for a finance dashboard that allows users to manage financial records, view analytics, and access data based on their roles.

The system demonstrates clean backend architecture, role-based access control, and structured API design.

---

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* PostgreSQL
* Maven

---

## Features

### 1. User & Role Management

* Create and manage users
* Assign roles: ADMIN, ANALYST, VIEWER
* Activate/deactivate users

### 2. Financial Records

* Create, update, delete records
* Fields include amount, type, category, date, description
* Supports filtering (extensible)

### 3. Dashboard APIs

* Total income
* Total expense
* Net balance

### 4. Role-Based Access Control (RBAC)

* ADMIN: Full access
* ANALYST: Read + dashboard
* VIEWER: Read-only

Implemented using:

* Spring Security
* Method-level security (`@PreAuthorize`)
* Custom filter for role simulation

### 5. Validation & Error Handling

* Input validation using annotations
* Global exception handler
* Structured error responses

---

## API Endpoints

### User APIs

* POST /users → Create user
* GET /users → Get all users
* PATCH /users/{id}/status → Update status

### Financial Records

* POST /records
* GET /records
* PUT /records/{id}
* DELETE /records/{id}

### Dashboard

* GET /dashboard/summary

---

## Sample Request

### Create User

POST /users

```json
{
  "name": "Anu",
  "email": "anu@test.com",
  "password": "1234",
  "role": "ADMIN"
}
```

---

## Running the Project

1. Clone the repository
2. Configure PostgreSQL in `application.yml`
3. Run the application

---

## Assumptions

* Authentication is simplified using header-based role simulation
* Focus is on backend design and logic

---

## Future Improvements

* JWT-based authentication
* Pagination & filtering
* Category-wise analytics
* Swagger API documentation

---

## Key Highlights

* Clean layered architecture (Controller → Service → Repository)
* DTO-based API design
* Proper separation of concerns
* Extensible security design

---
