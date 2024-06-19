# To build & run:

```
mvn spring-boot:build-image -Dspring-boot.build-image.imageName=incentro.com/camunda-app:0.1-SNAPSHOT && docker-compose up -d && docker-compose logs -f camunda-app
```