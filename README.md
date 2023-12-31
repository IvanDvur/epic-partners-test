# Приложение для инкремента счётчиков

----
## Запуск и развёртывание

----
При написании приложения был настроен CI/CD pipeline, с помощью Github CI(Actions). Основное назначение: автоматическая
сборка и пуш docker image на docker hub, при пуше коммитов в master ветку

Для запуска приложения необходимо клонировать на локальную машину файл **docker-compose.yml** и выполнить команду 
```docker-compose up``` из директории с указаным файлом.


# Описание

----
Приложение построено на основе архитектуры MVC. API сгенерирован на основе .yml спецификации Open API, расположенной в 
пакете **../resources/swagger** 

Стек технологий:

- Java 11
- Spring Boot
- Spring Data JPA
- Spring Web
- Thymeleaf
- Open API
- Swagger
- MySQL
- Apache Maven
- Docker
- Docker Compose

# Основная функциональность 

----
http://localhost:8080/swagger-ui/index.html - Документация по REST-endpoint, c возможностью тестирования

http://localhost:8080/ - Всё счётчики, хранящиеся в бд (поскольку в ТЗ не указано, нужно ли делать endpoint для создания
новых счётчиков, несколько счётчиков автоматически записываются в бд при старте приложения)




