FROM openjdk:17
ADD target/BestHospital-0.0.1-SNAPSHOT.jar BestHospital-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","BestHospital-0.0.1-SNAPSHOT.jar"]