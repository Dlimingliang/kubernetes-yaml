FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/
ADD ${DEPENDENCY}/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]