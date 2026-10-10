# inventory-api

A backend REST API for managing product inventory, built with Spring Boot and MySQL. I built this to get hands-on with Spring Data JPA, Hibernate, and RESTful API design patterns.

## Stack

- Java 21
- Spring Boot
- Hibernate / Spring Data JPA
- MySQL
- Maven
- JUnit 5 + Mockito

## Running locally

You'll need Java 21+ and MySQL installed.

```bash
git clone https://github.com/Mann473/inventory-api.git
cd inventory-api
```

Create the database:

```sql
CREATE DATABASE inventory_db;
```

Update the credentials in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=root
spring.datasource.password=your_password
```

Then run:

```bash
./mvnw spring-boot:run
```

App runs on `http://localhost:8080`

## Endpoints

```
GET     /api/products                      get all products
GET     /api/products/{id}                 get by id
GET     /api/products/category/{category}  get by category
POST    /api/products                      create a product
PUT     /api/products/{id}                 update a product
DELETE  /api/products/{id}                 delete a product
```

Example POST body:

```json
{
  "name": "Samsung Galaxy S24",
  "category": "Smartphones",
  "price": 999.99,
  "stockQuantity": 50
}
```

## Tests

```bash
./mvnw test
```
