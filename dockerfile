FROM adoptopenjdk:11-jre-hotspot
COPY /build/libs/adapter-0.0.1-SNAPSHOT.jar adapter-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "adapter-0.0.1-SNAPSHOT.jar"]