FROM openjdk:8-jdk-alpine
ENV UNIM_DB_URL=jdbc:postgresql://unimapp-db.cxeuejfgjqhf.us-west-2.rds.amazonaws.com:5432/unim?stringType=unspecified
ENV UNIM_DB_USER=postgres
ENV UNIM_DB_PASSWORD=Cmpunk22
ENV TOKEN_SECRET=unim_secret
ENV TOKEN_EXPIRED=3600000
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 5000