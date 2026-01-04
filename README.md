The Product API is a RESTful backend application developed using Spring Boot that provides complete CRUD (Create, Read, Update, Delete) operations for managing products.
The application follows clean layered architecture, uses Spring Data JPA with Hibernate, and exposes APIs documented via Swagger (OpenAPI).

This project is designed to demonstrate real-world backend development practices including REST design, database integration, API documentation, and Git version control.
product-api
│
├── controller      → REST Controllers
├── service         → Business Logic
├── repository      → Data Access Layer (JPA Repositories)
├── entity          → JPA Entities
├── exception       → Custom Exceptions & Global Handler
├── dto             → Request / Response DTOs
└── ProductApiApplication.java

Features:-
Create new product ,Retrieve all products ,Retrieve product by ID ,Update product details ,Delete product by ID, Swagger UI for API documentation ,Exception handling with proper HTTP status codes
JPA-based database interaction, RESTful API standards.

Author

Gourang Pandey
Java Backend Developer
Skills: Java, Spring Boot, Hibernate, MySQL, REST APIs, Git
GitHub: https://github.com/GourangPandey
