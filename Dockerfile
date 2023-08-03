FROM openjdk:20-jdk-slim
COPY out/artifacts/ipCheckerV1_jar/ipCheckerV1.jar app.jar
COPY src/data/ip-db.csv ip-db.csv
ENTRYPOINT ["java","-jar","/app.jar"]