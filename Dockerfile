FROM openjdk:8-jre-alpine
WORKDIR /
COPY TicklingClockApplication.jar TicklingClockApplication.jar
CMD ["java","-jar","TicklingClockApplication.jar"]
