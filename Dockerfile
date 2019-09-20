FROM maven:3.3-jdk-8-alpine

MAINTAINER  Sonam Agarwal <c2.sonam@gmail.com>
WORKDIR /
COPY pom.xml /pom.xml
COPY src/ /src
RUN mvn clean install
CMD ["java","-jar","/target/TicklingClockApplication-1.0-SNAPSHOT.jar"]
