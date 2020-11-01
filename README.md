ING Coding Challenge (non-reactive REST)

# Dependencies
* jdk11
* spring-boot
* spring-data - ORM (data repository)
* liquibase - for database upgrades (versioning)
* lombok - for less boilerplate codes
* sleuth - for easier request tracing

# Building the application
```
mvn clean package
```

# Running the application
```java
java -jar target\coding-challenge-0.0.1-SNAPSHOT.jar
```

# Users
|User ID   |Username  | Password | Role |
|----------|--------- |----------|------|
|1         |leonr     |password  |ADMIN |
|2         |aaronr    |password  |USER  | 
|3         |ethanc    |password  |USER  |
|4         |harrietm  |password  |USER  |
|5         |jaydend   |password  |USER  |
|6         |catherinew|game      |ADMIN |

# Testing
1. Get details of an existing user
   ```shell script
    curl -u jaydend:password -X PUT http://localhost:8080/api/userdetails/6 -H "Content-Type: application/json"
    ```
2. Get details - non-numeric id
   ```shell script
    curl -u jaydend:password -X PUT http://localhost:8080/api/userdetails/x6 -H "Content-Type: application/json"
    ```
   
3. Update details of an existing user as an admin 
     ```shell script
    curl -u leonr:password -X PUT http://localhost:8080/api/userdetails/2 -d '{"title":"hello"}' -H "Content-Type: application/json"
    ```

4. Update details of an existing user as a non-admin 
     ```shell script
    curl -u aaronr:password -X PUT http://localhost:8080/api/userdetails/2 -d '{"title":"hello", "address:{"street":"Street 25"}}' -H "Content-Type: application/json"
    ```

5. Update - incorrect password 
     ```shell script
    curl -u leonr:notcorrect -X PUT http://localhost:8080/api/userdetails/2 -d '{"title":"hello"}' -H "Content-Type: application/json"
    ```
   
6. Update - not existing user 
     ```shell script
    curl -u catherinew:game -X PUT http://localhost:8080/api/userdetails/100 -d '{"title":"Ms", "address":{"street":"Street 25"}}' -H "Content-Type: application/json"
    ```
   