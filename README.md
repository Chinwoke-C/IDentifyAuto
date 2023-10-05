

# IDentifyAuto

IDentifyAuto is a robust vehicle management system built with Java, Spring Boot, and GraphQL. It provides a flexible and efficient way to manage vehicle information, making it easy to retrieve and store vehicle details. Whether you need to query all vehicles, search by location, get vehicle details by VIN, or register a new vehicle, IDentifyAuto has you covered.
## Key Features

- Get All Vehicles: Retrieve a comprehensive list of all vehicles stored in the system, complete with their VINs, make, year, model, and location details.


- Search by Location: Search for vehicles based on a specified ZIP code, making it convenient to find vehicles in a specific area.


- Get Vehicle by VIN: Quickly access detailed information about a specific vehicle using its unique VIN (Vehicle Identification Number).


- Register New Vehicles: Register new vehicles into the system by providing essential details such as VIN, make, year, model, and location.

## Technology Stack

- Java: The application is built using Java, a widely used programming language known for its reliability and portability.


- Spring Boot: Spring Boot is used to develop the backend of the application, providing a robust and easily configurable framework for building RESTful APIs.


- GraphQL: GraphQL is the query language used for interacting with the API. It allows clients to request precisely the data they need, reducing over-fetching and under-fetching of data.


- Maven: The build tool used in this project is Maven, simplifying dependency management and project building.

## Getting Started
To get started with IDentifyAuto, follow these steps:
Prerequisites
Make sure you have the following software installed on your system:
- Java Development Kit (JDK)
- Spring Boot
- A GraphQL IDE or tool (e.g., Postman, Insomnia)

## Installation

1. Clone the IDentifyAuto repository to your local machine:

git clone https://github.com/your-username/IDentifyAuto.git



2. Navigate to the project directory:


cd IDentifyAuto



3. Build the project:



4. mvn clean install



5. Run the application:




mvn spring-boot:run


## GraphQL Endpoints
The following GraphQL endpoints are available:

1. Get All Vehicles:


query {
  getAllVehicles {
    vin
    make
    year
    model
    location {
      zipCode
      city
      state
    }
  }}



2. Search Vehicles by Location:


query {
  searchByLocation(zipCode: "12345") {
    vin
    make
    year
    model
    location {
      zipCode
      city
      state
    }
  }}



3. Get Vehicle by VIN:


query {
  getVehicleByVin(vin: "ABC123") {
    vin
    make
    year
    model
    location {
      zipCode
      city
      state
    }
  }}
 


4. Register a New Vehicle:



mutation {
  registerVehicle(vehicleRequest: {
    vin: "XYZ789"
    make: "Toyota"
    year: 2022
    model: "Corolla"
    location: {
      zipCode: "67890"
      city: "Example City"
      state: "CA"
    }
  }) {
    vin
    make
    year
    model
    location {
      zipCode
      city
      state
    }
  }}







