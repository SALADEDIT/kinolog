FROM openjdk:23
WORKDIR /usr/src/kinolog
COPY build/libs/kinolog-0.0.1-SNAPSHOT.jar kinolog-t.jar
ENTRYPOINT ["java","-jar","kinolog-t.jar"]