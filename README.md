# Secondo Mona Access Manager's backend

This is a backend application developed in Java using [Quarkus](https://quarkus.io/). 
It includes REST APIs, Qute templating, JWT-based authentication, PDF generation (OpenPDF), and integration with a Microsoft SQL Server database.

## Prerequisites

- Java 17 or higher
- Maven 3.8 or higher
- A running Microsoft SQL Server instance

### Dependencies

- quarkus-rest – REST endpoints
- quarkus-qute-web – Qute templating engine
- quarkus-jdbc-mssql – SQL Server connection
- quarkus-hibernate-orm-panache – Panache ORM
- quarkus-smallrye-jwt – JWT authentication
- openpdf – PDF generation
- quarkus-security-jpa – Security with JPA

---

## How to Run the Application

### 1. Clone the repository

git clone https://github.com/fabioporzio/Gruppo-4-PW3-Backend
cd Gruppo-4-PW3-Backend

### 2. Configure database access

Open the following file: 
src/main/resources/application.properties

Edit the following properties according to your database setup:
quarkus.datasource.db-kind=mssql
quarkus.datasource.username=YOUR_USERNAME
quarkus.datasource.password=YOUR_PASSWORD
quarkus.datasource.jdbc.url=jdbc:sqlserver://localhost:1433;databaseName=YOUR_DB
quarkus.hibernate-orm.database.generation=none
quarkus.http.cors.enabled=true
quarkus.http.cors.origins=*
quarkus.http.cors.methods=*
quarkus.http.cors.access-control-allow-credentials=true
🔒 Replace YOUR_USERNAME, YOUR_PASSWORD, and YOUR_DB with your actual database credentials and name.

### 3. Configure JWT support

Still in application.properties, configure JWT like this:
mp.jwt.verify.issuer=https://example.org/issuer

### 4. Start the application in development mode

./mvnw quarkus:dev

The app will be available at:
http://localhost:8080

## Project Structure

src/
└── main/
├── java/
│   └── data/
│       ├── model/            # Mapping of DB's tables
│       └── repository/       # Query to connect with the DB
│   └── service/              # Connects DB with web responses and viceversa
│   └── web/
│       ├── model/            # Web-specific models
│       └── resources/        # REST API endpoints
└── resources/
└── application.properties  # App configuration
