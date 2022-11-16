# START

open git bash in the folder, run *quarkus dev* command

## COMMENT

I did it quickly
- Need to add mappers for exceptions
- testing should be added
- need documentation for api
- ...

## create a company

POST
http://localhost:8080/api/company

{
    "name": "tesla",
    "balance": 350
}

## get company

GET
http://localhost:8080/api/company/1

## create a customer

POST
http://localhost:8080/api/customer

{
    "name": "jean"
}

## get customer

GET
http://localhost:8080/api/customer/1

## get customer global balance 

GET
http://localhost:8080/api/customer/balance/1

## get customer gift balance 

GET
http://localhost:8080/api/customer/balance/gift/1

## get customer meal balance

GET
http://localhost:8080/api/customer/balance/meal/1

## add gift

POST
http://localhost:8080/api/gift

{
    "companyId": 1,
    "customerId": 2,
    "amount": 150
}

## add meal

POST
http://localhost:8080/api/meal

{
    "companyId": 1,
    "customerId": 2,
    "amount": 150
}