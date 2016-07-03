FROM anapsix/alpine-java
COPY target/app*standalone.jar app.jar

ENV PORT 4000
EXPOSE 4000

CMD ["java", "-jar", "app.jar"]