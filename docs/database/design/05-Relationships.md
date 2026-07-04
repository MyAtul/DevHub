# 5. Relationships

## Purpose

This document defines the relationships between the business entities of the DevHub platform.

Entity relationships describe how business objects interact with one another and establish the conceptual foundation for the relational database model.

This document intentionally focuses on business relationships rather than implementation details such as foreign keys or ORM mappings.

---

# Relationship Design Principles

The DevHub entity model SHALL follow these principles:

- Relationships SHALL represent real business associations.
- Every relationship SHALL have a clearly defined purpose.
- Relationship ownership SHALL reflect business ownership.
- Bidirectional relationships SHOULD only be introduced when necessary.
- Many-to-Many relationships SHOULD be minimized where appropriate.
- Database implementation details SHALL be documented separately.

---

# Identity Domain

## User ↔ Role

**Relationship Type**

Many-to-Many

**Business Meaning**

A user may have multiple roles.

A role may be assigned to multiple users.

---

## Role ↔ Permission

**Relationship Type**

Many-to-Many

**Business Meaning**

A role consists of multiple permissions.

A permission may belong to multiple roles.

---

## User → RefreshToken

**Relationship Type**

One-to-Many

**Business Meaning**

A user may possess multiple refresh tokens across different authenticated sessions.

Each refresh token belongs to exactly one user.

---

# Module Catalog Domain

## User → Module

**Relationship Type**

One-to-Many

**Business Meaning**

A developer may publish multiple modules.

Each module has a single owner.

---

## Module → ModuleVersion

**Relationship Type**

One-to-Many

**Business Meaning**

A module may have multiple published versions.

Each version belongs to a single module.

---

## Module ↔ Category

**Relationship Type**

Many-to-One

**Business Meaning**

Each module belongs to one category.

A category may contain many modules.

---

## Module ↔ Tag

**Relationship Type**

Many-to-Many

**Business Meaning**

A module may contain multiple tags.

A tag may be associated with multiple modules.

---

# Documentation Domain

## Module → Documentation

**Relationship Type**

One-to-One

**Business Meaning**

Each module has one primary documentation.

Each documentation belongs to one module.

---

## Documentation → DocumentationSection

**Relationship Type**

One-to-Many

**Business Meaning**

Documentation is divided into multiple sections.

Each section belongs to a single documentation.

---

## DocumentationSection → CodeExample

**Relationship Type**

One-to-Many

**Business Meaning**

Each documentation section may contain multiple code examples.

Each code example belongs to a single documentation section.

---

# Downloads Domain

## User → Download

**Relationship Type**

One-to-Many

**Business Meaning**

A user may download multiple modules.

Each download record belongs to one user.

---

## Module → Download

**Relationship Type**

One-to-Many

**Business Meaning**

A module may be downloaded many times.

Each download references a single module.

---

## User → Favorite

**Relationship Type**

One-to-Many

**Business Meaning**

A user may favorite multiple modules.

Each favorite record belongs to one user.

---

## Module → Favorite

**Relationship Type**

One-to-Many

**Business Meaning**

A module may be favorited by many users.

Each favorite record references one module.

---

# Administration Domain

## User → AuditLog

**Relationship Type**

One-to-Many

**Business Meaning**

Administrative actions performed by a user are recorded as audit log entries.

Each audit log entry is associated with a single user.

---

# Relationship Summary

| Source Entity | Target Entity | Relationship |
|--------------|---------------|--------------|
| User | Role | Many-to-Many |
| Role | Permission | Many-to-Many |
| User | RefreshToken | One-to-Many |
| User | Module | One-to-Many |
| Module | ModuleVersion | One-to-Many |
| Category | Module | One-to-Many |
| Module | Tag | Many-to-Many |
| Module | Documentation | One-to-One |
| Documentation | DocumentationSection | One-to-Many |
| DocumentationSection | CodeExample | One-to-Many |
| User | Download | One-to-Many |
| Module | Download | One-to-Many |
| User | Favorite | One-to-Many |
| Module | Favorite | One-to-Many |
| User | AuditLog | One-to-Many |

---

# Relationship Guidelines

The following relationship types are used throughout DevHub:

## One-to-One (1:1)

Used when one business entity exclusively owns another.

Example:

- Module → Documentation

---

## One-to-Many (1:N)

Used when one entity owns multiple related entities.

Examples:

- User → Module
- Module → ModuleVersion
- Documentation → DocumentationSection

---

## Many-to-Many (N:N)

Used when both entities may be associated with multiple instances of the other.

Examples:

- User ↔ Role
- Role ↔ Permission
- Module ↔ Tag

Many-to-Many relationships SHOULD be implemented through junction tables in the physical database design.

---

# Related Documents

- 03-Entity-Catalog.md
- 04-Entity-Attributes.md
- 06-Constraints.md
- 09-ERD.md

---

# Summary

This document defines the conceptual relationships between the DevHub business entities.

These relationships establish the foundation for the physical database schema and the Entity Relationship Diagram (ERD), while remaining independent of implementation-specific database or ORM details.