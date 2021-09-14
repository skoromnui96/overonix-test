# Task
### Mandatory requirements
1) It should be a simple java application based on Spring Boot framework.
2) The application should have a REST API that allows users to search by address and get all addresses by coordinates.
3) The result should be printed in JSON format.
4) Your code should be version controlled and publicly accessible for us to review (github/bit-bucket/gitlab/etc)

### Nice to have:
1) Implement Authorization/Authentication for result endpoints.
2) Implement Cache for storing very often using coordinates.
3) Deploy application to Docker container (Dockerfile artifact).


### Task description:
You need to implement application that uses third party api Nominatim API and create the following endpoints:
1) To search by address and save coordinates(latitude,longitude) in H2 DB or any Persistence Db
2) To get all addresses by coordinates that have been stored in DB. The application must be called by REST API for receiving all addresses from Nominatim API  by saved coordinates.

## Usage
### Docker:
1) docker build -t overonix-test .
2) docker run -p 8080:8080 overonix-test

### Endpoints example:
1) http://127.0.0.1:8080/addresses/search-by-address?address=odessa
2) http://127.0.0.1:8080/addresses/search-by-coordinates?latitude=46.4873195&longitude=30.7392776

### Security:
username: overonix <br>
password: test