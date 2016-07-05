FROM anapsix/alpine-java
COPY target/stub*standalone.jar stub.jar

EXPOSE 4001

CMD ["java", "-jar", "stub.jar"]
