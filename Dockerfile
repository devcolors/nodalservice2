FROM openjdk:8-jdk-alpine
COPY build/libs/nodalService2-1.0-SNAPSHOT.jar nodalservice2.jar
ENTRYPOINT ["java", "-jar", "/nodalservice2.jar"]