
FROM java:8-jdk-alpine
COPY ./target/clouding-reactive-1.0.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "clouding-reactive-1.0.jar"]