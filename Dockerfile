FROM openjdk:8
EXPOSE 8080
COPY target/docker-my-app-1.0-SNAPSHOT.jar /home/docker-my-app-1.0-SNAPSHOT.jar 
CMD ["java","-jar","/home/my-app-1.0-SNAPSHOT.jar"]