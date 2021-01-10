## Application Architecture

![Arch diagram](./arch_diagram.jpg?raw=true "Architecture Diagram")

The application is composed of the components given in the above architecture diagram.
It consists of four Spring Boot microservices and a react frontend. The components are as follows

### Gateway Service

Acts as a API Gateway of the application and routes the requests to the appropriate microservice

### Discovery Service

Registers microservices with itself and facilitates intra-microservice communication

### Calculation Service

Exposes endpoint related to calculation

### Product Service

Stores information related to Product and Cartons

### React Frontend (My-App)

Contains the Web interface written using React

Note  - Database scripts have been included as init.sql
