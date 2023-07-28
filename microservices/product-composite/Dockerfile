FROM openjdk:12.0.2

LABEL authors="vikaswarkar"

EXPOSE 8080

ADD ./target/product-composite-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]