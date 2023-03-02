FROM alpine:latest

ADD Litres/ /app
WORKDIR /app

RUN apk add maven openjdk17
CMD ["mvn", "spring-boot:run"]