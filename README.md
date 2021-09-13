unim-apis
==========================

# What is it?

Backend for Unim App

# How to run it?

You need to add environment variables

    export UNIM_DB_URL=jdbc:postgresql://unimapp-db.cxeuejfgjqhf.us-west-2.rds.amazonaws.com:5432/unim
    export UNIM_DB_USER=postgres
    export UNIM_DB_PASSWORD=Cmpunk22
    export TOKEN_SECRET=unim_secret
    export TOKEN_EXPIRED=3600000 

For running on machine

    mvn package build

After the server is running, go to

```
http://localhost:5000/
```

# Link to the Swagger UI on local host

```
http://localhost:5000/swagger-ui.html
```

# Link to the Swagger UI on AWS EB

```
http://unimapp-dev.us-east-1.elasticbeanstalk.com/swagger-ui.html
```

The backend is done with
- Spring Boot 2.2.1.RELEASE
- Spring MVC, Spring Data JPA, Spring security and so on.



Backend is done with Java 8, without any xml. Tests are written in java using Mockito framework
