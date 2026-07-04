# 8. Authentication Flow

## Purpose

This document describes the authentication and authorization flow of the DevHub platform.

The objective is to define how users authenticate, how access to protected resources is controlled, and how JSON Web Tokens (JWT) are used to maintain a secure and stateless authentication mechanism.

---

# Authentication Overview

DevHub SHALL implement **JWT-based Authentication** using Spring Security.

The authentication process consists of the following stages:

- User Registration
- Email Verification
- User Login
- JWT Token Generation
- Access to Protected Resources
- Token Refresh
- User Logout

The authentication mechanism SHALL remain stateless, with each request carrying the necessary authentication information.

---

# Authentication Flow

```text
Guest
   │
   ▼
Register Account
   │
   ▼
Email Verification
   │
   ▼
Login
   │
   ▼
JWT Access Token + Refresh Token
   │
   ▼
Authenticated User
   │
   ▼
Access Protected APIs
   │
   ▼
Refresh Token (When Required)
   │
   ▼
Continue Session
   │
   ▼
Logout
```

---

# Registration Flow

```text
Guest
   │
   ▼
Submit Registration Form
   │
   ▼
Validate User Information
   │
   ▼
Create User Account
   │
   ▼
Generate Verification Token
   │
   ▼
Send Verification Email
```

The system **MUST** verify the uniqueness of the user's email address before creating a new account.

The account **MUST NOT** be fully activated until email verification is completed.

---

# Email Verification Flow

```text
User
   │
   ▼
Click Verification Link
   │
   ▼
Validate Verification Token
   │
   ▼
Activate Account
```

Only verified accounts SHALL be permitted to access protected resources.

---

# Login Flow

```text
User
   │
   ▼
Submit Credentials
   │
   ▼
Validate Credentials
   │
   ▼
Generate JWT Tokens
   │
   ▼
Return Access Token
```

Upon successful authentication, the backend SHALL issue:

- Access Token
- Refresh Token

The frontend SHALL use the Access Token when calling protected APIs.

---

# Protected Request Flow

```text
Client Request
      │
      ▼
Authorization Header
      │
      ▼
Spring Security Filter
      │
      ▼
JWT Validation
      │
      ▼
User Authentication
      │
      ▼
Role Verification
      │
      ▼
Controller
```

Requests with invalid or expired tokens SHALL be rejected.

---

# Refresh Token Flow

```text
Expired Access Token
        │
        ▼
Send Refresh Token
        │
        ▼
Validate Refresh Token
        │
        ▼
Generate New Access Token
        │
        ▼
Continue Session
```

Refresh Tokens SHALL be used only to obtain a new Access Token.

---

# Logout Flow

```text
Authenticated User
         │
         ▼
Logout Request
         │
         ▼
Invalidate Refresh Token
         │
         ▼
Remove Client Tokens
         │
         ▼
Session Terminated
```

After logout, the user SHALL be required to authenticate again before accessing protected resources.

---

# Authorization Flow

DevHub SHALL implement **Role-Based Access Control (RBAC)**.

Authorization SHALL be performed after successful authentication.

Supported roles include:

- Guest
- User
- Administrator

Each request SHALL be evaluated against the permissions associated with the authenticated user's role.

---

# Security Principles

The authentication system SHALL follow these principles:

- Stateless Authentication
- Secure Password Storage
- JWT-Based Authorization
- Role-Based Access Control
- Secure Token Handling
- Input Validation
- Least Privilege Principle

---

# Future Enhancements

Future releases MAY introduce:

- Multi-Factor Authentication (MFA)
- OAuth2 Authentication
- Social Login (Google, GitHub)
- Session Management Dashboard
- Device Management
- Login History
- Security Alerts

---

# Summary

The DevHub authentication architecture provides a secure, stateless, and scalable authentication mechanism using JWT and Spring Security.

By separating authentication from authorization and enforcing Role-Based Access Control (RBAC), the platform ensures that only authenticated and authorized users can access protected resources.