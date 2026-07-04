# 4. Entity Attributes

## Purpose

This document defines the attributes of each business entity in the DevHub platform.

The purpose of this document is to establish a consistent and complete data model before defining relationships, constraints, and the physical database schema.

Each entity includes its business attributes, expected data type, whether the attribute is mandatory, and its business purpose.

Relationships, keys, and implementation-specific details are intentionally documented separately.

---

# Attribute Design Principles

The DevHub entity model SHALL follow these principles:

- Each attribute SHALL represent a single business concept.
- Attribute names SHALL be descriptive and consistent.
- Every entity SHALL include auditing information where appropriate.
- Only business attributes SHALL be defined in this document.
- Relationship fields SHALL be documented separately.

---

# Identity Domain

## User

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| username | String | Yes | Unique username of the developer |
| email | String | Yes | User email address |
| password | String | Yes | Encrypted password |
| firstName | String | Yes | User's first name |
| lastName | String | Yes | User's last name |
| avatarUrl | String | No | Profile image URL |
| bio | Text | No | Short developer biography |
| accountStatus | Enum | Yes | Current account status |
| emailVerified | Boolean | Yes | Email verification status |
| createdAt | Timestamp | Yes | Account creation time |
| updatedAt | Timestamp | Yes | Last profile update |

---

## Role

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| name | String | Yes | Role name |
| description | String | No | Role description |
| createdAt | Timestamp | Yes | Creation timestamp |

---

## Permission

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| name | String | Yes | Permission name |
| description | String | No | Permission description |

---

## RefreshToken

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| token | String | Yes | Refresh token value |
| expiresAt | Timestamp | Yes | Expiration date |
| revoked | Boolean | Yes | Revocation status |
| createdAt | Timestamp | Yes | Creation timestamp |

---

# Module Catalog Domain

## Module

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| name | String | Yes | Module name |
| slug | String | Yes | URL-friendly identifier |
| summary | String | Yes | Short module summary |
| description | Text | Yes | Detailed description |
| currentVersion | String | Yes | Latest stable version |
| status | Enum | Yes | Publication status |
| repositoryUrl | String | No | Source repository |
| documentationUrl | String | No | Documentation link |
| createdAt | Timestamp | Yes | Creation timestamp |
| updatedAt | Timestamp | Yes | Last modification |

---

## ModuleVersion

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| version | String | Yes | Version number |
| releaseNotes | Text | No | Release notes |
| changelog | Text | No | Version changes |
| downloadUrl | String | Yes | Download location |
| checksum | String | No | File integrity checksum |
| releasedAt | Timestamp | Yes | Release timestamp |

---

## Category

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| name | String | Yes | Category name |
| description | String | No | Category description |

---

## Tag

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| name | String | Yes | Tag name |

---

# Documentation Domain

## Documentation

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| title | String | Yes | Documentation title |
| overview | Text | Yes | Documentation overview |
| version | String | Yes | Documentation version |
| lastUpdated | Timestamp | Yes | Last update |

---

## DocumentationSection

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| title | String | Yes | Section title |
| content | Text | Yes | Section content |
| displayOrder | Integer | Yes | Display sequence |

---

## CodeExample

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| title | String | Yes | Example title |
| language | String | Yes | Programming language |
| sourceCode | Text | Yes | Code snippet |
| explanation | Text | No | Code explanation |

---

# Downloads Domain

## Download

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| downloadedAt | Timestamp | Yes | Download time |
| ipAddress | String | No | Client IP |
| userAgent | String | No | Browser information |

---

## Favorite

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| createdAt | Timestamp | Yes | Date favorited |

---

# Administration Domain

## AuditLog

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| action | String | Yes | Action performed |
| entityName | String | Yes | Target entity |
| entityId | String | Yes | Target entity identifier |
| description | Text | No | Additional details |
| createdAt | Timestamp | Yes | Event timestamp |

---

## SystemSetting

| Attribute | Type | Required | Description |
|-----------|------|----------|-------------|
| key | String | Yes | Setting key |
| value | String | Yes | Setting value |
| description | String | No | Setting description |
| updatedAt | Timestamp | Yes | Last update |

---

# Common Auditing Attributes

The following attributes SHOULD be included in entities where applicable:

| Attribute | Type | Description |
|-----------|------|-------------|
| createdAt | Timestamp | Creation timestamp |
| updatedAt | Timestamp | Last modification timestamp |

---

# Related Documents

- 03-Entity-Catalog.md
- 05-Relationships.md
- 06-Constraints.md

---

# Summary

This document defines the business attributes for every entity in the DevHub platform.

These attribute definitions provide the foundation for the relational database schema, JPA entities, DTOs, and API contracts while remaining independent of implementation-specific details.