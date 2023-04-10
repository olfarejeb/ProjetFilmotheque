FROM openjdk:20-ea-17-jdk
ADD ./target/filmotheque-0.0.1-SNAPSHOT.jar filmotheque-0.0.1-SNAPSHOT.jar 
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "filmotheque-0.0.1-SNAPSHOT.jar"]
