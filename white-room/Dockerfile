FROM java:openjdk-8-jre
COPY target/white-room-0.1-SNAPSHOT-standalone.jar white-room-0.1-SNAPSHOT-standalone.jar

ENV PORT 4000
EXPOSE 4000

CMD ["java", "-jar", "white-room-0.1-SNAPSHOT-standalone.jar"]
