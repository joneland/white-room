FROM anapsix/alpine-java
COPY target/app*standalone.jar app.jar

EXPOSE 4000

CMD ["java", "-jar", "app.jar"]