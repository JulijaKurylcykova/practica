FROM openjdk:11-jdk-slim
EXPOSE 8080
COPY target/*.jar /deployments/app.jar
CMD java -jar /deployments/app.jar