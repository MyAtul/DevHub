# 7. Request Flow

## Purpose

This document describes how requests are processed within the DevHub platform.

It defines the flow of a request from the client application to the backend, through the business modules, and back to the client.

Understanding the request flow helps maintain consistency across all modules and ensures proper separation of responsibilities.

---

# Overview

Every client request SHALL follow a consistent processing pipeline.

The frontend communicates with the backend using secure REST APIs over HTTPS.

Each request passes through authentication, validation, business logic, data access, and response generation before returning to the client.

---

# Request Processing Flow

```text
User
   │
   ▼
React Frontend
   │
   ▼
REST API Request
   │
   ▼
Spring Security Filter
   │
   ▼
JWT Authentication
   │
   ▼
Controller
   │
   ▼
Request Validation
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
PostgreSQL Database
   │
   ▼
Repository Layer
   │
   ▼
Service Layer
   │
   ▼
DTO Mapping
   │
   ▼
Controller
   │
   ▼
HTTP Response (JSON)
   │
   ▼
React Frontend
   │
   ▼
User
```

---

# Request Lifecycle

## Step 1 – Client Request

The user performs an action within the React application.

Examples include:

- Logging in
- Viewing modules
- Searching documentation
- Downloading a module
- Updating a profile

The frontend sends an HTTP request to the backend.

---

## Step 2 – Security Processing

Every incoming request passes through Spring Security.

Responsibilities include:

- Authentication
- JWT validation
- Role verification
- Access control

Protected endpoints MUST require a valid JWT access token.

---

## Step 3 – Controller Layer

The controller receives the request.

Responsibilities include:

- Request mapping
- Input validation
- Delegating processing to the service layer
- Returning HTTP responses

Controllers MUST remain lightweight and MUST NOT contain business logic.

---

## Step 4 – Validation

Incoming request data SHALL be validated before business processing begins.

Validation includes:

- Required fields
- Data format
- Field length
- Business constraints

Invalid requests SHALL return standardized validation errors.

---

## Step 5 – Service Layer

The service layer contains the business logic.

Responsibilities include:

- Processing business rules
- Coordinating workflows
- Authorizing operations
- Managing transactions
- Calling repositories

All business logic SHALL reside within the service layer.

---

## Step 6 – Repository Layer

Repositories interact with the database.

Responsibilities include:

- CRUD operations
- Query execution
- Data persistence

Repositories MUST remain independent of business logic.

---

## Step 7 – Database

PostgreSQL stores all persistent application data.

The database is responsible for:

- Data storage
- Relationships
- Constraints
- Transactions

The frontend MUST NEVER communicate directly with the database.

---

## Step 8 – Response Processing

After retrieving data:

- Entities are converted into DTOs.
- Business responses are prepared.
- Standardized API responses are generated.

The backend returns a JSON response to the frontend.

---

## Step 9 – Frontend Rendering

The frontend processes the response.

Responsibilities include:

- Updating the UI
- Displaying notifications
- Handling errors
- Refreshing cached data
- Rendering new content

---

# Error Handling Flow

When an error occurs, the following flow SHALL be followed:

```text
Request
    │
    ▼
Controller
    │
    ▼
Service
    │
    ▼
Exception Thrown
    │
    ▼
Global Exception Handler
    │
    ▼
Standard Error Response
    │
    ▼
Frontend
```

All API errors SHALL return a standardized response format.

---

# Authentication Flow

For protected endpoints:

```text
Client Request
       │
       ▼
Authorization Header
       │
       ▼
JWT Validation
       │
       ▼
Authentication Success
       │
       ▼
Controller Execution
```

Requests with invalid or expired tokens SHALL be rejected before reaching the controller.

---

# Design Principles

The request flow SHALL follow these principles:

- Stateless communication
- Secure request processing
- Layered responsibility
- Centralized validation
- Consistent error handling
- Standardized API responses
- Clear separation of concerns

---

# Summary

Every request within DevHub follows a consistent and secure lifecycle from the client to the database and back.

By enforcing a standardized request flow, the platform remains maintainable, secure, scalable, and predictable across all business modules.