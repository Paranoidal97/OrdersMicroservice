FROM eclipse-temurin:17-jdk-alpine
COPY target/OrdersMicroservice-0.0.1-SNAPSHOT.jar OrdersMicroservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/OrdersMicroservice-0.0.1-SNAPSHOT.jar"]