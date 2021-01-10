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

## Setting Up

#### Pre-requisites

* Java 1.8
* Postgres
* npm

1) Clone the repository

2) Build CalculationService,DiscoveryService, GatewayService and ProductService by typing by changing directory to each project and folder and typing 
`./mvnw install` . The Spring boot jar will be generated inside target folder

3) Change directory into 'my-app' folder which contains the React Frontend and type `npm install` to fetch and install the necessary dependencies

4) Currently the postgres credentials are as follows . This is stored and used by ProductService . You can create a postgres user 'product_user' with database 'product_db' and password '1234' or change them to an existing user/db and rebuild ProductService. 

* spring.datasource.url=jdbc:postgresql://localhost:5432/product_db
* spring.datasource.username=product_user
* spring.datasource.password=1234

5) Create the schema and tables using init.sql 

6) start the microservices by typing `java -jar <artifact.jar>` in the following order

1. DiscoveryService
2. ProductService
3. CalculationService
4. GatewayService

7) spin up the frontend by typing 'npm start' after changing directory into my-app project

8) Access the UI by typing localhost:3000


