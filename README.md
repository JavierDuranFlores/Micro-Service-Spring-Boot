# API Documentation
## Base URL
http://localhost:8090

## Authentication
### Endpoint
POST /login
### Request
curl --location --request POST 'http://localhost:8090/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "usuario": "usr-admin",
    "password": "superusuario"
}'


## Endpoints
### 1. Get Book by ID
### Enpoint
GET /:id
### Request
curl --location --request GET 'localhost:8090/1' \
--header 'Authorization: Bearer YOUR_JWT_TOKEN'
### 2. Create a New Book
### Endpoint
POST /
### Request
curl --location --request POST 'http://localhost:8090' \
--header 'Authorization: Bearer YOUR_JWT_TOKEN' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "Crime and Punishment",
    "author": "Fyodor Dostoevsky",
    "isbn": "9780486415871"
}'
### 3. Update an Existing Book
### Endpoint
PUT /:id

### Request
curl --location --request PUT 'http://localhost:8090/11' \
--header 'Authorization: Bearer YOUR_JWT_TOKEN' \
--header 'Content-Type: application/json' \
--data-raw '{
    "title": "Crimes and Punishment",
    "author": "Fyodor Dostoevsky",
    "isbn": "9780486415871"
}'
### 4. Delete a Book
### Endpoint
DELETE /:id
### Request
curl --location --request DELETE 'localhost:8090/11' \
--header 'Authorization: Bearer YOUR_JWT_TOKEN'
