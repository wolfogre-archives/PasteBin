FROM java:8

MAINTAINER Jason Song

ADD target/pastebin-*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
