FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8080
ADD ./target/counter-test.jar counter-test.jar
ENTRYPOINT ["java","-jar","counter-test.jar"]