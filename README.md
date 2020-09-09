# Seat Booking App - REST API
> Seat reservation system for an office

## Table of Contents
* [General Info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Contact](#contact)

## General Info
The purpose of the project was to build a seat reservation system for an office as a REST service.

## Technologies
* Java 11, Spring (Boot, Data, REST), JPA & Hibernate, PostgreSQL

## Setup
To start with this application you need to have [PostgreSQL](https://www.postgresql.org/download/) installed - apart from JVM of course!
* Clone or download this repo to your computer. Notice a path of the project directory.
* Open a terminal and execute command below - it builds the PostgreSQL database with all test data.
```
psql -h localhost -p 5432 -U postgres -f X:\your-own-path-to-the-project-directory\seat-booking-app\src\main\resources\sql\sql-script.sql
```
* Then go to the project directory in a command line and run the application:
```
$ .\mvnw spring-boot:run
```
* Now you can run the project in a browser or as a [Postman client](https://www.postman.com/).

## Features
* The system covers a single office with multiple floors and rooms.
* Employee can select a time interval in which he/she would like to book the seat for.
```
curl --request GET 'http://localhost:8080/api/v1/rooms/search/findByProjectDateTimeBetween?startDateTime=2020-08-29T08:00:00&endDateTime=2020-08-30T21:00:00&sort=roomTitle'
```
* To book seats employee chooses a particular room, seats, and also has to provide personal information (name and e-mail address).
* Provided name and surname should be at least three characters long and start with a capital letter. The surname could also consist of two parts separated with a single dash. Keep in mind the second part should also start with a capital letter.
```
curl  --request POST 'localhost:8080/api/v1/employeeBooking'
      --header 'Content-Type: application/json'
      --data-raw '{"room":{"id":1},
      "seatReservations":[{"id":1},{"id":2},{"id":3}],
      "employee":{"firstName":"Ashok","lastName":"Kumar","emailAddress":"ashok.kumar@xyz.com"}}'
```
* The system gives back the reservation expiration time as a JSON.
- @PostMapping in the REST controller is the only way to book tickets, as a valid request body.
* HTTP methods such as POST, PUT and DELETE are disabling for the particular entities - but of course, the GET method is available to get information about rooms, seats, etc.

