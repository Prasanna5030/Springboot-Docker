FROM openjdk
LABEL authors="Prasanna"
WORKDIR /app
ENV PORT 8080
EXPOSE 8080
ADD target/docker-demo.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]