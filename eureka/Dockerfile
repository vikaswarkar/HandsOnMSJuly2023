FROM openjdk:12.0.2

LABEL authors="vikaswarkar"

EXPOSE 8761

ADD ./target/eureka-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]