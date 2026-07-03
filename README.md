# Project Overview

# Full Stack Calculator

A full-stack calculator application built with React and Spring Boot.

## Features

- Addition
- Subtraction
- Multiplication
- Division
- Power
- Square Root
- Percentage

## Technology Stack

### Frontend
- React
- TypeScript
- Axios
- Vite

### Backend
- Spring Boot 3
- Java 21
- Maven
- JUnit 5

# Setup Instructions

## Backend Setup

Navigate to backend directory:
cd backend
run - mvn spring-boot:run
backend will start on **http://localhost:8080**


## Frontend Setup

Navigate to frontend directory:
cd frontend
npm install - to install dependecies
npm run dev - start application
http://localhost:5173 - UI url 


## API Usage

### Add
POST /api/calculator/add

Request : {
  "num1": 10,
  "num2": 2
}
Response 
{
  "result": 5
}

### Square Root
POST /api/calculator/sqrt

Request : {
  "num1": 25
}
Response 
{
  "result": 5
}

### Running tests 

Backend tests: 
mvn tests

mvn clean verify will generate coverage report at this location - target/site/jacoco/index.html


## Design Rationale

```md
## Design Decisions

### Backend

- Controller layer handles HTTP requests and responses.
- Service layer encapsulates business logic.
- Global exception handler provides consistent error responses.
- Bean validation ensures request validation.

### Frontend

- API calls are isolated in a dedicated service layer.
- Client-side validation prevents unnecessary API calls.
- Error handling provides meaningful feedback to users.
- Responsive layout supports desktop and mobile devices.

### Testing

- Unit tests cover calculator business logic.
- Edge cases such as division by zero and negative square root inputs are validated.

## Docker

Build the backend image:

```bash
mvn clean package
docker build -t calculator-backend .

docker run -p 8080:8080 calculator-backend
The API will be available at localhost://8080
