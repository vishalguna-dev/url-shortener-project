# 🚀 URL Shortener Service — Core Implementation (Phase 1)

This repository contains a high-performance URL shortening service developed using **Spring Boot 3**. This phase focuses on the essential backend architecture, database integration, and a validated web interface for end-users.

## 🛠️ Tech Stack & Prerequisites

* **Java 17** (or higher)
* **Spring Boot 3.x**
* **Spring Data JPA** (Hibernate)
* **MySQL** (Persistence)
* **Thymeleaf** (Template Engine)
* **Validation API** (Jakarta Validation)



## 📋 Key Modules & Implementation Details

### 1. Project Initialization & Infrastructure

Established the project baseline using Maven. Configured the environment to handle external properties for **MySQL** connectivity, ensuring the application can successfully communicate with the database to store and retrieve URL mappings.

### 2. Domain Modeling with Spring Data JPA

Developed the core `UrlMapping` entity to bridge the gap between Java objects and the database schema.

* **Unique Slugs:** Implemented logic to store and query unique "short codes" (slugs).
* **Repository Pattern:** Leveraged `JpaRepository` to abstract complex SQL queries, focusing on clean service-layer logic.

### 3. Advanced Persistence: Solving Hibernate Pitfalls

A critical technical focus was placed on managing the **JPA/Hibernate LazyLoadingException**.

* Analyzed data fetching strategies to ensure associated entities are loaded correctly without performance bottlenecks.
* Learned how to navigate Hibernate's proxy system to prevent runtime crashes during data serialization.

### 4. Dynamic UI with Thymeleaf

Created a server-side rendered frontend using **Thymeleaf**.

* **Model Attributes:** Utilized Spring's `Model` to pass data between the controller and the view.
* **User Interface:** Designed a clean landing page for users to submit long URLs and view generated results instantly.

### 5. Input Security & Data Validation

Implemented a robust validation layer to protect the integrity of the database.

* **Constraint Annotations:** Used `@NotBlank` and `@URL` to ensure that only legitimate, formatted web addresses are processed.
* **UI Feedback:** Integrated dynamic error messaging in the frontend to guide users when an invalid entry is detected, preventing "junk" data from entering the system.

---

## 🚦 How to Run Locally

1. **Database Setup:** Create a schema named `url_shortener` in your MySQL instance.
2. **Configuration:** Update `src/main/resources/application.properties` with your credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/url_shortener
spring.datasource.username=YOUR_USER
spring.datasource.password=YOUR_PASSWORD

```


3. **Build & Run:**
```bash
./mvnw spring-boot:run

```


4. **Access:** Navigate to `http://localhost:8080` in your browser.
