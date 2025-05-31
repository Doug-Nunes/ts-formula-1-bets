# Formula 1 BETs

A Spring Boot application for managing Formula 1 betting events, including user management, event sessions, and driver information.

## Technologies Used

- **Java 17+**
- **Maven**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Cloud**
- **PostgreSQL**
- **Flyway**
- **OpenAPI (Swagger)**
- **Logback**
- **Docker**

## Project Structure

- `src/main/java/com/formula/bet/builder/`  
  Builder and Data Transfer Object (DTO) classes.
- `src/main/java/com/formula/bet/client/`  
  Interfaces for REST clients to external services.
- `src/main/java/com/formula/bet/config/`  
  Application configuration classes.
- `src/main/java/com/formula/bet/controller/`  
  REST controllers for handling HTTP requests.
- `src/main/java/com/formula/bet/exception/`  
  Custom exception classes and handlers.
- `src/main/java/com/formula/bet/model/`  
  Domain model classes representing application entities.
- `src/main/java/com/formula/bet/repository/`  
  Repository interfaces for data access.
- `src/main/java/com/formula/bet/service/`  
  Service classes implementing business logic.

## API Documentation

Access the Swagger UI for interactive API documentation at:  
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven
- Docker

### Setup Instructions

1. **Clone the repository:**
   ```sh
   git clone <repository-url>
   cd ts-formula-1-bets
    ```
   
2. **Configure the application:**
   - Ensure there is an application.yml file in the src/main/resources folder with your environment settings.


3. **Start PostgreSQL with Docker:**
   ```sh
   docker run --name postgres-server -e POSTGRES_USER=formulaUser -e POSTGRES_PASSWORD=pwd123 -e POSTGRES_DB=formula -p 5432:5432 -d postgres:latest
   ```
   
4. **Run the application:**
   ```sh
    mvn spring-boot:run
   ```