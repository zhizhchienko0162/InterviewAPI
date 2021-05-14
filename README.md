# API для системы опросов
Для разворачивания системы необходимо выполнить команды:
```
mvnw spring-boot:build-image
docker run -dp 8080:8080 interview:1.0.0
```
или
```
mvnw package
java -jar ./target/interview-1.0.0.jar
```
