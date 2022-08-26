#FROM --platform=linux/amd64 adoptopenjdk/openjdk11:alpine-jre
FROM --platform=linux/arm64/v8 azul/zulu-openjdk-alpine:17.0.4-17.36.15-jre-headless
RUN apk --no-cache add curl && apk add --no-cache bash
ARG JAR_FILE=./build/libs/*-SNAPSHOT.jar
COPY ${JAR_FILE} /app/spring-boot-application.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Dfile.encoding=UTF-8","-jar","/app/spring-boot-application.jar"]