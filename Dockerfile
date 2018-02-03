FROM openjdk:8-jdk-alpine
MAINTAINER DiscussionService 
COPY discussion-service-0.0.1-SNAPSHOT.jar /home/discussion-service-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/home/discussion-service-0.0.1-SNAPSHOT.jar"]
