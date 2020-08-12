FROM openjdk:8-jdk-alpine
ARG WAR_FILE=target/*.war
ADD ${WAR_FILE} wordcounter.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/wordcounter.war"]