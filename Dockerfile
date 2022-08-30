FROM openjdk:8
VOLUME /tmp
EXPOSE 9090
ADD target/backendProject.jar backendProject.jar
ENTRYPOINT  ["java", "-jar", "/backendProject.jar"]