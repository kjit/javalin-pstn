FROM openjdk:8-jre-alpine

EXPOSE 7000

ADD target/javalin-server-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/src/javalin/javalin-server.jar
WORKDIR /usr/src/javalin

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/src/javalin/javalin-server.jar"]
