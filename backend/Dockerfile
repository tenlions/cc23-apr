FROM openjdk:17-jdk-slim
MAINTAINER nloewes
COPY ./target/roshambr-0.0.1-SNAPSHOT.jar /usr/src/roshambr/
WORKDIR /usr/src/roshambr
EXPOSE 8080
CMD ["java", "-jar", "roshambr-0.0.1-SNAPSHOT.jar"]
