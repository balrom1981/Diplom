## Процедура запуска тестов сервиса покупки путешествий для MySql
1. Клонируем [репозиторий](https://github.com/balrom1981/Diplom) на свой компьютер.
1. Открываем его с помощью JetBrains IntelliJ IDEA Ultimate.
1. Запускаем контейнеры MySql и Node c помощью команды 
``` docker-compose up -d --force-recreate ```.
1. Проверяем, что контейнеры запустились командой ``` docker-compose ps ```.
1. Проверить командой ``` docker-compose logs -f mysql (docker-compose logs -f node-app) ``` готовность MySql (Node).
1. Запускаем приложение командой ``` java -jar artifacts/aqa-shop.jar ```.
1. Запускаем тесты командой 
``` gradlew clean test allureReport ```.
1. Формируем отчет командой ``` gradlew allureServe ```.
1. Оцениваем результаты тестирования.

## Процедура запуска тестов сервиса покупки путешествий для PostgreSQL
1. Клонируем [репозиторий](https://github.com/balrom1981/Diplom) на свой компьютер.
1. Открываем его с помощью JetBrains IntelliJ IDEA Ultimate.
1. В файле application.propertiers меняем строку ``` spring.datasource.url=jdbc:mysql://localhost:3306/app ``` на строку ``` spring.datasource.url=jdbc:postgresql://localhost:5432/app```.
1. В DatabaseHelper в методах getStatusPaymentWithoutCredit, getStatusPaymentWithCredit, cleanDataBase меням url ```jdbc:mysql://localhost:3306/app``` на ```jdbc:postgresql://localhost:5432/app``` .
1. Запускаем контейнеры PostgreSQL и Node c помощью команды 
``` docker-compose up -d --force-recreate ```.
1. Проверяем, что контейнеры запустились командой ``` docker-compose ps ```.
1. Проверить командой ``` docker-compose logs -f postgres (docker-compose logs -f node-app) ``` готовность Postgres (Node).
1. Запускаем приложение командой ``` java -jar artifacts/aqa-shop.jar ```.
1. Запускаем тесты командой 
``` gradlew clean test allureReport ```.
1. Формируем отчет командой ``` gradlew allureServe ```.
1. Оцениваем результаты тестирования.