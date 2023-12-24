# Spring Boot Batch Demo

This is a spring boot batch application which exposes a rest endpoint for executing the JOB.

## Requirements

To compile and run this demo you will need:

- JDK 11+
- GraalVM

In addition, you will need either a PostgreSQL database, or Docker to run one.

## Building the demo

Launch the Maven build on the checked out sources of this demo:

> ./mvnw clean package -DskipTests

## Running the demo

### Live coding with Quarkus

> ./mvnw spring-boot:run -DskipTests

Next we need to make sure you have a PostgreSQL instance running. To set up a PostgreSQL database with Docker:

> docker run -d --name db-server -e POSTGRES_USER=test -e POSTGRES_PASSWORD=test -e POSTGRES_DB=test -p 5432:5432 postgres