# Full Stack Calculator Application

A full-stack calculator application built using Spring Boot (backend) and React + Vite (frontend). The application supports basic arithmetic operations through a REST API and provides a responsive user interface for performing calculations.

---

## Features

### Supported Operations

- Addition
- Subtraction
- Multiplication
- Division
- Exponentiation
- Square Root
- Percentage

### Frontend

- React + Vite
- Responsive UI
- Client-side validation
- Error handling and user feedback
- API integration with backend services

### Backend

- Spring Boot REST API
- Layered architecture (Controller → Service)
- Request validation
- Centralized exception handling
- Unit tested business logic

---

## Project Structure

```text
calculator/
├── backend/
│   └── sezzle-calculator/
├── frontend/
├── docker-compose.yml
└── README.md
```

---

## Technology Stack

### Backend

- Java 21
- Spring Boot
- Maven
- JUnit 5

### Frontend

- React
- Vite
- Material UI
- Axios

### DevOps

- Docker
- Docker Compose

---

## Setup Instructions

### Prerequisites

- Java 21+
- Maven 3.9+
- Node.js 20+
- npm
- Docker (Optional)

---

## Running the Backend

Navigate to the backend project:

```bash
cd backend/sezzle-calculator
```

Build the application:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

Backend will be available at:

```text
http://localhost:8080
```

---

## Running the Frontend

Navigate to frontend:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Start development server:

```bash
npm run dev
```

Frontend will be available at:

```text
http://localhost:5173
```

---

## API Examples

### Addition

Request:

```http
POST /api/calculate
```

```json
{
  "operation": "ADD",
  "firstNumber": 10,
  "secondNumber": 5
}
```

Response:

```json
{
  "result": 15
}
```

---

### Subtraction

```json
{
  "operation": "SUBTRACT",
  "firstNumber": 10,
  "secondNumber": 5
}
```

Response:

```json
{
  "result": 5
}
```

---

### Multiplication

```json
{
  "operation": "MULTIPLY",
  "firstNumber": 10,
  "secondNumber": 5
}
```

Response:

```json
{
  "result": 50
}
```

---

### Division

```json
{
  "operation": "DIVIDE",
  "firstNumber": 10,
  "secondNumber": 5
}
```

Response:

```json
{
  "result": 2
}
```

---

### Exponentiation

```json
{
  "operation": "POWER",
  "firstNumber": 2,
  "secondNumber": 3
}
```

Response:

```json
{
  "result": 8
}
```

---

### Square Root

```json
{
  "operation": "SQRT",
  "firstNumber": 25
}
```

Response:

```json
{
  "result": 5
}
```

---

### Percentage

```json
{
  "operation": "PERCENTAGE",
  "firstNumber": 50,
  "secondNumber": 200
}
```

Response:

```json
{
  "result": 25
}
```

---

## Design Decisions

### Backend

- Spring Boot was chosen for rapid API development and maintainability.
- Business logic is isolated in the Service layer.
- Controllers handle request/response orchestration only.
- Global exception handling provides consistent API error responses.
- Validation ensures invalid requests are rejected early.
- REST APIs follow a simple request/response model for easy frontend integration.

### Frontend

- React with Vite provides a lightweight and fast development experience.
- API communication is abstracted into a dedicated service layer.
- Form validation is performed before API submission.
- Error messages are displayed clearly to improve user experience.
- Responsive layout supports desktop and mobile devices.

### Architecture

- Clear separation of concerns between UI and business logic.
- Stateless REST API design.
- Frontend and backend can be deployed independently.

---

## Running Tests

Backend unit tests:

```bash
cd backend/sezzle-calculator

mvn test
```

---

## Coverage Report

Generate coverage report:

```bash
mvn clean test jacoco:report
```

Coverage report location:

```text
target/site/jacoco/index.html
```

Open the generated HTML report in a browser to view detailed code coverage metrics.

---

## Docker

### Backend Docker Image

Navigate to backend:

```bash
cd backend/sezzle-calculator
```

Build image:

```bash
docker build -t calculator-backend .
```

Run container:

```bash
docker run -p 8080:8080 calculator-backend
```

Backend API:

```text
http://localhost:8080
```

---

## Running Full Stack with Docker Compose

From repository root:

```bash
docker-compose up --build
```

Services:

| Service | URL |
|----------|----------|
| Frontend | http://localhost:5173 |
| Backend | http://localhost:8080 |


## Prompts

During development, the following prompts were given:

- Fixed handling of zero results (`0`) to ensure calculations displaying `0` are rendered correctly instead of being treated as a falsy value.
- Implemented regex-based input validation to allow only valid numeric values and prevent invalid API requests.
- Cleared previous calculation results when displaying validation or API error messages to avoid stale information.
- Cleared previous error messages upon successful calculations.
