FROM openjdk:11
ADD target/overonix-test-docker.jar overonix-test-docker.jar
ENTRYPOINT ["java", "-jar","overonix-test-docker.jar"]
EXPOSE 8080