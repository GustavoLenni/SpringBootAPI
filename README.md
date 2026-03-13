# Initial

A Spring Boot CRUD project with REST endpoints and JPA persistence.

## 🧩 Project Structure

- `src/main/java` - application source code
  - `com.InitializadorAplication` - main starter class
  - `controllers/UserController` - REST endpoint for user operations
  - `dtos/UserDto` - data transfer object for user payloads
  - `model/User` - JPA entity for user data
  - `repositories/UserRepository` - Spring Data JPA repository
- `src/main/resources` - application configuration
  - `application.properties` - Spring Boot configuration

## 🚀 Prerequisites

- Java 25 (as configured in `pom.xml`)
- Maven (recommended: use the included Maven wrapper)

## ▶️ Running the App

From the project root:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
./mvnw.cmd spring-boot:run
```

The application will start on `http://localhost:8080` by default.

## 🧪 Running Tests

```bash
./mvnw test
```

## 📦 Packaging

Create an executable jar:

```bash
./mvnw package
```

Then run:

```bash
java -jar target/Initial-0.0.1-SNAPSHOT.jar
```

## 🔧 Configuration

Update `src/main/resources/application.properties` to configure datasource and other settings.

## 🐳 Docker (PostgreSQL)

This project includes a `docker-compose.yml` that starts a PostgreSQL database matching the default Spring Boot configuration.

Start the database:

```bash
docker compose up -d
```

Stop it:

```bash
docker compose down
```

If you change the DB name/credentials in `docker-compose.yml`, update `src/main/resources/application.properties` accordingly or override via environment variables (e.g. `SPRING_DATASOURCE_URL`).

## 🧭 Notes

- This project uses Spring Boot 4.x and Spring Data JPA.
- The current configuration includes a PostgreSQL driver as runtime dependency.

---

If you want help adding endpoints, persistence configuration, or Docker support, just ask!