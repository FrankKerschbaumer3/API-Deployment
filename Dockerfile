FROM openjdk:8-jdk-alpine
COPY discussion-service-0.0.1-SNAPSHOT.jar /home/api/api.jar
EXPOSE 8080
RUN ls /home/api
CMD java -jar /home/api/api.jar
