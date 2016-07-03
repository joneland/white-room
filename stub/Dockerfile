FROM anapsix/alpine-java
COPY target/stub*standalone.jar stub.jar

ENV PORT 4001
EXPOSE 4001

CMD ["java", "-jar", "stub.jar"]