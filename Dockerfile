FROM openjdk:8
ARG JAR_FILE=target/my-app-1.0-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} /my-app-1.0-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","my-app-1.0-SNAPSHOT.jar.jar"]
