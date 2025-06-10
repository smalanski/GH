# Greenhouse Vegetable Tracker

A Spring Boot application that helps users track vegetables planted in different greenhouses, their planting dates, expected harvest dates, and other related information.

## Features

- **Greenhouse Management**: Create, view, edit, and delete greenhouses with details like name, location, and size
- **Vegetable Tracking**: Track vegetables with information like name, variety, planting date, and expected harvest date
- **Harvest Calendar**: View which vegetables are ready or approaching harvest time
- **Search & Filter**: Search for vegetables and greenhouses by name, and filter vegetables by planting date range
- **Responsive UI**: Modern responsive design that works on desktop and mobile devices
- **Data Validation**: Form validation for all user inputs
- **RESTful API**: Complete API for integration with other systems

## Technology Stack

- **Backend**: Java 21, Spring Boot 3.2.3, Spring Data JPA, Spring MVC, Spring Validation
- **Frontend**: Thymeleaf templates, Bootstrap 5, Font Awesome icons
- **Database**: H2 (embedded file-based database)
- **Build Tool**: Maven
- **Others**: Lombok, Spring DevTools

## Getting Started

### Prerequisites

- Java 21 or later
- Maven

### Running the Application

1. Clone this repository
2. Navigate to the project directory
3. Build and run the application using Maven:

```bash
mvn clean install
mvn spring-boot:run
```

4. The application will be accessible at http://localhost:8080

### Web Interface

The application provides a complete web interface:

- **Home Dashboard**: http://localhost:8080/
- **Greenhouses**: http://localhost:8080/greenhouses
- **Vegetables**: http://localhost:8080/vegetables
- **Harvest Calendar**: http://localhost:8080/vegetables/ready-to-harvest

### Accessing the H2 Console

The H2 database console is available at http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:file:./greenhousedb
- Username: sa
- Password: password

## API Endpoints

### Greenhouses

- `GET /api/greenhouses` - Get all greenhouses
- `GET /api/greenhouses/{id}` - Get a specific greenhouse by ID
- `POST /api/greenhouses` - Create a new greenhouse
- `PUT /api/greenhouses/{id}` - Update an existing greenhouse
- `DELETE /api/greenhouses/{id}` - Delete a greenhouse

### Vegetables

- `GET /api/vegetables` - Get all vegetables
- `GET /api/vegetables/{id}` - Get a specific vegetable by ID
- `GET /api/greenhouses/{greenhouseId}/vegetables` - Get all vegetables in a specific greenhouse
- `POST /api/greenhouses/{greenhouseId}/vegetables` - Add a new vegetable to a greenhouse
- `PUT /api/vegetables/{id}` - Update an existing vegetable
- `DELETE /api/vegetables/{id}` - Delete a vegetable
- `GET /api/vegetables/search?name={name}` - Search vegetables by name
- `GET /api/vegetables/planted-between?start={date}&end={date}` - Find vegetables planted between specific dates
- `GET /api/vegetables/ready-to-harvest?before={date}` - Find vegetables ready to harvest before a specific date

## Sample JSON Payloads

### Greenhouse

```json
{
  "name": "Main Greenhouse",
  "location": "Backyard",
  "sizeSqm": 50.0
}
```

### Vegetable

```json
{
  "name": "Tomato",
  "variety": "Cherry",
  "plantingDate": "2025-05-15",
  "expectedHarvestDate": "2025-08-01",
  "notes": "Needs extra watering during hot days"
}
```

## Project Structure

```
greenhouse-tracker/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── greenhouse/
│   │   │           ├── controller/
│   │   │           │   ├── api/
│   │   │           │   │   ├── GreenhouseRestController.java
│   │   │           │   │   └── VegetableRestController.java
│   │   │           │   ├── web/
│   │   │           │   │   ├── GreenhouseWebController.java
│   │   │           │   │   ├── HomeController.java
│   │   │           │   │   └── VegetableWebController.java
│   │   │           │   └── VegetableController.java
│   │   │           ├── dto/
│   │   │           │   ├── GreenhouseDto.java
│   │   │           │   └── VegetableDto.java
│   │   │           ├── model/
│   │   │           │   ├── Greenhouse.java
│   │   │           │   └── Vegetable.java
│   │   │           ├── repository/
│   │   │           │   ├── GreenhouseRepository.java
│   │   │           │   └── VegetableRepository.java
│   │   │           ├── service/
│   │   │           │   ├── GreenhouseService.java
│   │   │           │   └── VegetableService.java
│   │   │           └── GreenhouseApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── css/
│   │       │   │   └── styles.css
│   │       │   └── js/
│   │       │       └── scripts.js
│   │       ├── templates/
│   │       │   ├── greenhouse/
│   │       │   │   ├── form.html
│   │       │   │   ├── list.html
│   │       │   │   └── view.html
│   │       │   ├── vegetable/
│   │       │   │   ├── form.html
│   │       │   │   ├── harvest.html
│   │       │   │   ├── list.html
│   │       │   │   └── view.html
│   │       │   ├── home.html
│   │       │   └── layout.html
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── greenhouse/
│                   └── GreenhouseApplicationTests.java
├── greenhousedb.mv.db
├── pom.xml
└── README.md
```

## Future Enhancements

- User authentication and authorization
- Image upload for vegetables and greenhouses
- Weather integration for growing conditions
- Notifications for upcoming harvests
- Mobile app version

## License

This project is licensed under the MIT License.
