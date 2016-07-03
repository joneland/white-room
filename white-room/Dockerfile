FROM anapsix/alpine-java
COPY target/white-room-*-standalone.jar app.jar

ENV PORT 4000
EXPOSE 4000

CMD ["java", "-jar", "app.jar"]
