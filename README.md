# Spring-firebase-crud
This repository contains a Spring Boot application that demonstrates a CRUD (Create, Read, Update, Delete) functionality using Firebase as the database. The application provides a RESTful API for managing data and leverages the Spring Boot framework along with Firebase's real-time database capabilities.

## Features

- Create new records in the database.
- Retrieve existing records based on specified criteria.
- Update records with new information.
- Delete records from the database.
- Real-time synchronization with Firebase's NoSQL database.
- Easy-to-use RESTful API.

## Getting Started
### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven  (for building and managing dependencies)
- Firebase account
- IDE of your choice (prefer IntelJ Ultimate) 
#### Setup Firebase
- Create a new project in your Firebase console.
- Obtain the Firebase configuration settings for your project.
- Configure your Spring Boot application to use these settings for Firebase connectivity. You can do this by adding the configuration to your application.properties or application.yml file.

## Running the Application
- Clone this repository: git clone https://github.com/abdellah-belcaid/spring-firebase-crud.git
- Navigate to the project directory: cd spring-firebase-crud
- Build the project: mvn clean install 
- Run the application: mvn spring-boot:run 
- The application will start, and you'll be able to access the API endpoints at http://localhost:8080.

### API Endpoints

- POST /api/v1/Student/ : Create a new Student.
- GET /api/v1/Student/ : Retrieve all Students.
- GET /api/v1/Student/{StudentId} : Retrieve a specific Student by ID.
- PUT /api/v1/Student/{StudentId} : Update an existing Student.
- DELETE /api/v1/Student/{Studentd}: Delete an Student.