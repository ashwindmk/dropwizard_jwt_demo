# Dropwizard JWT Demo

https://github.com/auth0/java-jwt

### Get Token
```
curl --location --request POST 'http://localhost:8080/student/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "alice@gmail.com",
    "password": "pass123"
}
'
```

### Get Data using Token
```
curl --location --request GET 'http://localhost:8080/student/' \
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJKLzUxMiJ9.eyJzdWIiOiJhbGljZUBnbWFpbC5jb20iLCJyb2xlcyI6WyJhZG1pbiIsInVzZXIiXSwiaXNzIjoiYXV0aDAiLCJuYW1lIjoiYWxpY2VAZ21haWwuY29tIiwiZXhwIjoxNjAxMDA3NjA1fQ.yZX3O2nylOYGzDGuLSmpB3rLcnsHeHuM8-BQ2wuuSz_a0vfIR68h0vPHSGDAnrJfqS1axMDKZQX4ToE4OqqGWw' \
--data-raw ''
```

### Health Check
```
GET http://localhost:8081/healthcheck
```
