# 6. Constraints

## Purpose

This document defines the integrity constraints for the DevHub database.

Constraints ensure that the database maintains valid, consistent, and reliable data throughout the application's lifecycle.

These rules are independent of application logic and SHALL be enforced at the database level whenever appropriate.

---

# Constraint Design Principles

The DevHub database SHALL follow these principles:

- Every entity SHALL have a unique identifier.
- Required business data SHALL NOT be nullable.
- Duplicate business records SHALL be prevented where necessary.
- Relationships SHALL maintain referential integrity.
- Invalid data SHALL be rejected by the database.
- Constraints SHALL support long-term data consistency.

---

# Primary Key Constraints

Every entity SHALL contain a Primary Key.

| Entity | Primary Key |
|---------|-------------|
| User | id |
| Role | id |
| Permission | id |
| RefreshToken | id |
| Module | id |
| ModuleVersion | id |
| Category | id |
| Tag | id |
| Documentation | id |
| DocumentationSection | id |
| CodeExample | id |
| Download | id |
| Favorite | id |
| AuditLog | id |
| SystemSetting | id |

Primary Keys SHALL uniquely identify each record within the database.

---

# Foreign Key Constraints

The following relationships SHALL be enforced using Foreign Keys.

| Parent Entity | Child Entity |
|--------------|--------------|
| User | RefreshToken |
| User | Module |
| Module | ModuleVersion |
| Category | Module |
| Module | Documentation |
| Documentation | DocumentationSection |
| DocumentationSection | CodeExample |
| User | Download |
| Module | Download |
| User | Favorite |
| Module | Favorite |
| User | AuditLog |

Many-to-Many relationships SHALL be implemented using junction tables.

---

# Unique Constraints

The following business attributes SHALL remain unique.

| Entity | Attribute |
|---------|-----------|
| User | username |
| User | email |
| Module | slug |
| Category | name |
| Tag | name |
| Role | name |
| Permission | name |
| SystemSetting | key |

These constraints prevent duplicate business data.

---

# NOT NULL Constraints

The following attributes SHALL always contain values.

## User

- username
- email
- password
- firstName
- lastName
- accountStatus
- createdAt
- updatedAt

---

## Module

- name
- slug
- summary
- description
- currentVersion
- status
- createdAt
- updatedAt

---

## ModuleVersion

- version
- downloadUrl
- releasedAt

---

## Documentation

- title
- overview
- version
- lastUpdated

---

## Download

- downloadedAt

---

## AuditLog

- action
- entityName
- entityId
- createdAt

---

# Check Constraints

The database SHOULD validate business rules where appropriate.

Examples include:

- Account status SHALL contain only valid values.
- Module status SHALL contain only valid values.
- Version numbers SHALL follow the supported versioning format.
- Release dates SHALL NOT be earlier than creation dates where applicable.

---

# Default Values

Certain attributes SHOULD receive default values.

Examples include:

| Attribute | Default Value |
|-----------|---------------|
| createdAt | Current Timestamp |
| updatedAt | Current Timestamp |
| emailVerified | false |
| revoked | false |
| accountStatus | ACTIVE |
| status | DRAFT |

These defaults simplify record creation while maintaining consistency.

---

# Referential Integrity

The database SHALL enforce referential integrity.

Examples include:

- A ModuleVersion SHALL belong to an existing Module.
- Documentation SHALL reference an existing Module.
- A Favorite SHALL reference both an existing User and Module.
- A Download SHALL reference both an existing User and Module.

Orphaned records SHALL be prevented.

---

# Business Integrity Rules

The following business rules SHALL be maintained:

- Every Module SHALL have one owner.
- Every Documentation SHALL belong to one Module.
- Every RefreshToken SHALL belong to one User.
- Every Download SHALL reference one Module.
- Every Favorite SHALL reference one User and one Module.

These rules ensure consistency between business operations and stored data.

---

# Related Documents

- 04-Entity-Attributes.md
- 05-Relationships.md
- 07-Index-Strategy.md
- 09-ERD.md

---

# Summary

The constraints defined in this document establish the integrity rules of the DevHub database.

By enforcing these rules at the database level, the platform maintains consistent, reliable, and secure data while reducing the possibility of invalid or orphaned records.

These constraints form the foundation for the physical database schema and support the long-term maintainability of the platform.