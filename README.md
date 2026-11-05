# liga-crud

Учебное REST-приложение

## Стек

- Java 21
- Spring Boot 3.5.16
- Maven
- Spring Data JPA (Hibernate)
- PostgreSQL 17
- OpenAPI 3 и Swagger UI

## Локальный запуск

По умолчанию приложение подключается к базе `liga_crud` на `localhost:5433` с
логином и паролем `postgres`. Эти значения подходят для PostgreSQL из
`compose.yaml`.

```powershell
docker compose up -d
mvn spring-boot:run
```

Настройки можно переопределить переменными окружения:

```powershell
$env:DB_URL = "jdbc:postgresql://localhost:5433/liga_crud"
$env:DB_USERNAME = "postgres"
$env:DB_PASSWORD = "your_password"
mvn spring-boot:run
```

Swagger UI доступен по адресу:

- http://localhost:8080/swagger-ui.html

OpenAPI-описание в формате JSON:

- http://localhost:8080/v3/api-docs
