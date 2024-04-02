FROM openjdk:17-alpine
EXPOSE 5500
ADD target/money-transfer-service-0.0.1.jar mts.jar
CMD ["java", "-jar", "/mts.jar"]