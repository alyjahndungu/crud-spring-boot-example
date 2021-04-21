# easy-software-spring-boot-app

Clone the repository

create a database in postgreSQL named easysoft

##Endpoints

###creating new customer
http://localhost:8085/api/v1/customers

Json Body =  

{
"customerId":"EP-0001",
"firstname":"Elijah",
"lastname":"Ndung'u",
"phoneNo": "0741862008"
}

###requesting loan
http://localhost:8085/api/v1/loans/requests?customerId=EP-0001

json body

{
"transactionId": "MERT78456465",
"amount" : "45000",
"interest" : "850",
"loanCode" : "127",
"loanDate" : "2021-08-19",
"loanDueDate" : "2021-10-23"
}

###Getting loan requests of given customer EP-001

http://localhost:8085/api/v1/loans/requests?customerId=EP-0001

### Getting loans by id

http://localhost:8085/api/v1/loans?id=1

### Updating loan requests by PUT method

PUT: http://localhost:8085/api/v1/loans/requests?id=1

JSON BODY

{
"transactionId": "MERT78456465",
"amount" : "45000",
"interest" : "850",
"loanCode" : "127",
"loanDate" : "2021-08-19",
"loanDueDate" : "2021-10-23"
}

### updating loan requests by PATCH method

PATCH  http://localhost:8085/api/v1/loans/requests/1

JSON BODY

{
"transactionId": "MERT78456465",
"amount" : "45000",
"interest" : "850",
"loanCode" : "127",
"loanDate" : "2021-08-19",
"loanDueDate" : "2021-10-23"
}