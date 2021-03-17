FROM openjdk:8-alpine
WORKDIR /workdir
COPY /src/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]