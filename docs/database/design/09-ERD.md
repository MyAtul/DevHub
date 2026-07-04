# 9. Entity Relationship Diagram (ERD)

## Purpose

This document provides the Entity Relationship Diagram (ERD) for the DevHub database.

The ERD is a visual representation of the approved database design and illustrates the relationships between business entities.

Unlike the previous database design documents, which define the business concepts individually, the ERD presents the complete relational model of the platform in a single view.

The ERD is derived from the approved database documentation and SHALL remain consistent with:

- Business Domains
- Entity Catalog
- Entity Attributes
- Relationships
- Constraints
- Normalization Strategy

---

# Objectives

The Entity Relationship Diagram exists to:

- Visualize the complete database model.
- Illustrate relationships between entities.
- Improve understanding of the domain model.
- Support backend implementation.
- Support database migration planning.
- Serve as a reference during future development.

---

# Diagram Conventions

The ERD follows the following conventions.

## Entities

Each rectangle represents a business entity.

Examples include:

- User
- Module
- Documentation
- Category
- Tag

---

## Relationships

Relationships are represented using standard cardinality notation.

Supported relationship types include:

- One-to-One (1:1)
- One-to-Many (1:N)
- Many-to-Many (N:N)

---

## Primary Keys

Each entity includes its Primary Key.

Primary Keys uniquely identify each record.

---

## Foreign Keys

Foreign Keys represent relationships between entities.

Foreign Keys SHALL follow the relationships defined in:

- 05-Relationships.md
- 06-Constraints.md

---

# Entity Summary

The current database model contains the following entities.

## Identity

- User
- Role
- Permission
- RefreshToken

---

## Module Catalog

- Module
- ModuleVersion
- Category
- Tag

---

## Documentation

- Documentation
- DocumentationSection
- CodeExample

---

## Downloads

- Download
- Favorite

---

## Administration

- AuditLog
- SystemSetting

---

# Diagram Source

The official DevHub ERD SHALL be maintained separately from this document.

Recommended formats include:

- Draw.io
- dbdiagram.io
- Mermaid
- PlantUML

The exported diagram SHOULD be stored alongside this document.

Example:

```text
docs/
└── database/
    └── design/
        ├── 09-ERD.md
        ├── DevHub-ERD.drawio
        ├── DevHub-ERD.svg
        └── DevHub-ERD.png
```

---

# Relationship Summary

The ERD represents the following business relationships.

| Source | Relationship | Target |
|----------|--------------|---------|
| User | Many-to-Many | Role |
| Role | Many-to-Many | Permission |
| User | One-to-Many | RefreshToken |
| User | One-to-Many | Module |
| Module | One-to-Many | ModuleVersion |
| Category | One-to-Many | Module |
| Module | Many-to-Many | Tag |
| Module | One-to-One | Documentation |
| Documentation | One-to-Many | DocumentationSection |
| DocumentationSection | One-to-Many | CodeExample |
| User | One-to-Many | Download |
| Module | One-to-Many | Download |
| User | One-to-Many | Favorite |
| Module | One-to-Many | Favorite |
| User | One-to-Many | AuditLog |

---

# Design Principles

The Entity Relationship Diagram SHALL adhere to the following principles:

- Reflect the approved business model.
- Avoid duplicated relationships.
- Maintain normalized data structures.
- Clearly identify ownership.
- Remain synchronized with all database documentation.

Changes to the ERD SHALL only occur after the corresponding design documents have been updated and approved.

---

# Related Documents

- 01-Database-Overview.md
- 02-Business-Domains.md
- 03-Entity-Catalog.md
- 04-Entity-Attributes.md
- 05-Relationships.md
- 06-Constraints.md
- 07-Index-Strategy.md
- 08-Normalization.md

---

# Summary

The Entity Relationship Diagram provides a visual representation of the DevHub database model.

It serves as a communication tool between developers, architects, and future contributors while ensuring that the implemented database remains aligned with the approved design documentation.

The ERD is derived from the database design documents and SHALL evolve only through the established documentation and architecture review process.