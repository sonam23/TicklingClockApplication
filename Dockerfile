FROM maven:3.6.2-jdk-8-slim AS MAVEN_PACKAGE
MAINTAINER  Sonam Agarwal <c2.sonam@gmail.com>
WORKDIR /tmp/
COPY pom.xml /tmp/
COPY src /tmp/src/
RUN mvn package

FROM openjdk:8-jdk-slim
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY --from=MAVEN_PACKAGE /tmp/target/TicklingClockApplication*.jar TicklingClockApplication.jar

CMD ["java","-jar","TicklingClockApplication.jar"]
#CMD ["bash"]
