FROM eclipse-temurin:17-jdk-alpine
COPY /OrdersMicroservice/target/orders-microservice-0.0.1-SNAPSHOT.jar orders-microservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/orders-microservice-0.0.1-SNAPSHOT.jar"]