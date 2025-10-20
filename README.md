# REST API - Spring Boot Project

## Description

This project is a simple REST API developed with Spring Boot to manage tasks. 
It allows creating, listing, updating, and deleting tasks with information 
such as task name, delivery date, and responsible person.

## Technologies Used

- Java 21
- Spring Boot 3.3.4
- Spring Data JPA
- Hibernate
- MySQL (connector)
- Maven

## Features

- List all tasks
- Retrieve a task by ID
- Create a new task
- Update an existing task
- Delete a task

## How to Run the Project Locally

### Prerequisites

- Java 21 installed
- Maven installed
- MySQL (or another configured database) running locally
- Configure the database in the file `src/main/resources/application.properties`

Example database configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
