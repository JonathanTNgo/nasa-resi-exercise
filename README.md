# Mars Rover Photo Server

This is a Spring Boot application written with Java 17 that lets users retrieve data from NASA's Mars Rover Photos API (rovers, and photos)


## Exposed REST Endpoints

- `GET /api/dates`
  - `localhost:8080/api/rovers`
  - (No Text-Body provided) Get a list of filtered dates from imageDates.txt (located in main/resources folder)
  - (Text-Body provided) Get a list of filtered dates from text-body provided

- `GET /api/rovers`
  - `localhost:8080/api/rovers`
  - Get a list of Mars rovers.

- `GET /api/photos/list`
  - `localhost:8080/api/photos/list?rover_name=curiosity&earth_date=2017-2-27`
  - Get list of photos taken by a specific rover on a specific date.

- `GET /api/photos`
  - `localhost:8080/api/photos?photo_link=http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01622/opgs/edr/fcam/FLB_541484941EDR_F0611140FHAZ00341M_.JPG`
  - Retrieve an single image using its source http address.

## Prerequisites

- Java 17
- Maven 3.x



## Installing

- Clone this repo
- Enter local directory, and install. This will download all dependencies and runs the tests.

```bash
mvn clean install
```

## Running
- Run the application with. This will start the server at localhost:8080

```bash
mvn spring-boot:run
```

- Test the application with

```bash
mvn test
```

## Built With
- Java 17
- Spring Boot
- Maven
- JUnit

