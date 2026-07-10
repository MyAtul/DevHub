# Authentication Module Documentation (Sprint 2)

## Module Overview

The Authentication module is responsible for user registration, authentication, and request authorization using JWT (JSON Web Tokens). It securely stores user credentials using BCrypt, validates incoming requests, generates and validates JWT access tokens, integrates with Spring Security, and provides a reusable authentication foundation for future DevHub modules.

---

# Module Responsibilities

* Register new users
* Authenticate existing users
* Encrypt passwords using BCrypt
* Generate JWT access tokens
* Validate JWT access tokens
* Authenticate protected requests
* Populate the Spring Security SecurityContext
* Validate incoming requests
* Prevent duplicate usernames and email addresses
* Return standardized API responses
* Maintain audit information (`createdAt`, `updatedAt`)

---

# Current Features

## Registration

**Endpoint**

`POST /api/v1/auth/register`

### Business Rules

* Email must be unique.
* Username must be unique.
* Password is stored as a BCrypt hash.
* User is enabled by default.
* Email is not verified by default.
* Audit timestamps are generated automatically.

### Request

```json
{
  "firstName": "Atul",
  "lastName": "Yadav",
  "username": "atul123",
  "email": "atul@example.com",
  "password": "Password123"
}
```

### Success Response (201 Created)

```json
{
  "id": 1,
  "username": "atul123",
  "email": "atul@example.com",
  "message": "User registered successfully"
}
```

### Possible Errors

| Status | Exception                      | Description             |
| ------ | ------------------------------ | ----------------------- |
| 400    | Validation Error               | Invalid request body    |
| 409    | EmailAlreadyExistsException    | Email already exists    |
| 409    | UsernameAlreadyExistsException | Username already exists |

---

## Login

**Endpoint**

`POST /api/v1/auth/login`

### Business Rules

* User must exist.
* Password must match the stored BCrypt hash.
* A JWT access tokenHash is generated after successful authentication.
* Email not found and incorrect password return the same error message.

### Request

```json
{
  "email": "atul@example.com",
  "password": "Password123"
}
```

### Success Response (200 OK)

```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiJ9...",
  "tokenType": "Bearer",
  "expiresIn": 3600,
  "id": 1,
  "username": "atul123",
  "email": "atul@example.com",
  "message": "Login Successful"
}
```

### Possible Errors

| Status | Exception                   | Description               |
| ------ | --------------------------- | ------------------------- |
| 400    | Validation Error            | Invalid request body      |
| 401    | InvalidCredentialsException | Invalid email or password |

---

# JWT Authentication

## JWT Claims

The generated access tokenHash contains the following claims:

| Claim      | Description          |
| ---------- | -------------------- |
| `sub`      | User email           |
| `userId`   | User ID              |
| `username` | Username             |
| `iss`      | Token issuer         |
| `iat`      | Issued timestamp     |
| `exp`      | Expiration timestamp |

Example payload:

```json
{
  "sub": "atul@example.com",
  "userId": 1,
  "username": "atul123",
  "iss": "devhub",
  "iat": 1783400263,
  "exp": 1783403863
}
```

---

# Protected Endpoints

Public endpoints:

```
POST /api/v1/auth/register
POST /api/v1/auth/login
```

All other endpoints require a valid JWT.

Clients must send the JWT in the Authorization header:

```http
Authorization: Bearer <access_token>
```

---

# Authentication Flow

```text
Client
   │
   ▼
POST /login
   │
   ▼
Validate Credentials
   │
   ▼
Generate JWT
   │
   ▼
Return Access Token
   │
   ▼
──────────────────────────────
Subsequent Requests
──────────────────────────────
Authorization: Bearer <JWT>
   │
   ▼
JwtAuthenticationFilter
   │
   ▼
Extract JWT
   │
   ▼
Extract Email (Subject)
   │
   ▼
Load UserDetails
   │
   ▼
Validate JWT
   │
   ▼
Populate SecurityContext
   │
   ▼
Controller
```

---

# Spring Security Components

The authentication pipeline currently consists of:

* `SecurityConfig`
* `JwtAuthenticationFilter`
* `JwtService`
* `JwtServiceImpl`
* `CustomUserDetailsService`
* `PasswordEncoder (BCrypt)`
* `DaoAuthenticationProvider`

Authentication is stateless and performed for every protected request.

---

# Database

## Table

`users`

### Columns

* id
* first_name
* last_name
* username
* email
* password
* enabled
* email_verified
* created_at
* updated_at

The database schema is managed exclusively using Flyway migrations.

---

# Package Structure

```text
modules/
└── auth/
    ├── config/
    │   ├── JwtProperties.java
    │   └── SecurityConfig.java
    ├── controller/
    ├── dto/
    ├── entity/
    ├── repository/
    ├── security/
    │   ├── CustomUserDetailsService.java
    │   ├── JwtAuthenticationFilter.java
    │   ├── JwtClaims.java
    │   ├── JwtService.java
    │   └── JwtServiceImpl.java
    └── service/

common/
├── config/
│   └── JpaAuditConfig.java
├── exception/
└── response/
```

---

# Security

* Passwords are encrypted using BCrypt.
* Passwords are never stored in plain text.
* JWTs are signed using HMAC SHA.
* JWT expiration is configurable.
* Authentication is stateless.
* HTTP sessions are disabled.
* Every protected request is authenticated using JWT.
* Authentication information is stored in the Spring Security `SecurityContext`.

---

# Exception Handling

All business exceptions extend `BusinessException`.

Current exceptions:

* EmailAlreadyExistsException
* UsernameAlreadyExistsException
* InvalidCredentialsException

Global exception handling is implemented using `@ControllerAdvice`.

Example error response:

```json
{
  "timestamp": "2026-07-06T18:20:30",
  "status": 409,
  "error": "Conflict",
  "message": "Email already exists",
  "path": "/api/v1/auth/register"
}
```

---

# Validation

Request validation uses Jakarta Bean Validation.

Current annotations:

* `@NotBlank`
* `@Email`
* `@Size`

Validation is automatically executed using `@Valid`.

---

# Testing Completed

## Registration

* Successful registration
* Duplicate email
* Duplicate username
* Invalid request payload
* Empty request body

## Login

* Successful login
* Invalid password
* Unknown email

## JWT

* JWT generation
* JWT claim extraction
* JWT signature verification
* JWT expiration validation
* JWT validation
* JWT authentication filter execution

## Security

* Access protected endpoint without JWT
* Access protected endpoint with valid JWT
* Access protected endpoint with expired JWT
* SecurityContext population
* BCrypt password hashing
* Automatic audit timestamps
* Global exception handling
* Unknown JSON fields are ignored

---

# Architectural Decisions

* Package-by-feature architecture
* Modular authentication design for future DevHub extraction
* Flyway as the single source of truth for database schema
* Constructor injection
* DTOs for API communication
* JPA Auditing
* Global exception handling using `@ControllerAdvice`
* Stateless JWT authentication
* Spring Security filter-based authentication
* Externalized JWT configuration using `JwtProperties`

---

# Current Module Structure

```
Authentication Module
│
├── Registration
├── Login
├── Password Encryption
├── JWT Generation
├── JWT Validation
├── Spring Security Integration
├── Protected Endpoint Authentication
├── Global Exception Handling
└── Validation
```

---

# Future Enhancements (Sprint 3+)

* Refresh tokenHash support
* TokenPair abstraction
* Logout
* User profile endpoint (`/me`)
* Email verification
* Password reset
* Account locking after repeated failed login attempts
* Role-Based Access Control (RBAC)
* OAuth2 / Social Login
* Multi-factor authentication (optional)

---

# Module Status

**Status:** ✅ Completed (Sprint 2)

The Authentication module now provides a complete JWT-based authentication system with secure user registration, login, stateless request authentication, and Spring Security integration. This implementation serves as the foundation for the future **DevHub Auth** reusable module, which will later support refresh tokens, RBAC, and additional authentication features while remaining portable across multiple Spring Boot applications.
