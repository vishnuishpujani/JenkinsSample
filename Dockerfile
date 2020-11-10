FROM openjdk:8
EXPOSE 8080
COPY target/my-app-1.0-SNAPSHOT.jar /my-app-1.0-SNAPSHOT.jar 
CMD ["/usr/bin/java","-jar","/my-app-1.0-SNAPSHOT.jar"]
