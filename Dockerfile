FROM openjdk:8
EXPOSE 8080
ADD target/docker-my-app-1.0-SNAPSHOT.jar docker-my-app-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/my-app-1.0-SNAPSHOT"]