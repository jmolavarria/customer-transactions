# Demo transaction app
Spring boot 3.0.2 application with angular to create new account of customer with transactions

Front only view of customer ifo is implemented

## Backend
To start the backend do: `cd demo-app && mvn spring-boot::run`

Using JDK 17

## Frontend
To start the application do: `cd demfront && ng serve --proxy-config proxy.conf.json`

To add this project for CI/CD, frontend part must be stored in a separated project, it will ease the build and testing with a proper docker image.     

Only view of the customer information has been implemented.

It can be accessed on http://localhost:4200/customer-info?customerId=1
Where customerId 1 is already in db.


### Frontend Installation
- Install nodejs v19.6.1 and client
- npm install in the frontend directory

## Local access to DB
Access to DB when running in local
http://localhost:8080/h2-console/