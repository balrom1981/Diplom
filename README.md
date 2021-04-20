[Ссылка на план тестирования](https://github.com/balrom1981/Diplom/blob/master/myreports/Plan.md).

## Процедура запуска тестов сервиса покупки путешествий для MySql
1. Клонируем [репозиторий](https://github.com/balrom1981/Diplom) на свой компьютер.
1. Открываем его с помощью JetBrains IntelliJ IDEA Ultimate.
1. Запускаем контейнеры MySql и Node c помощью команды 
``` docker-compose up -d --force-recreate ```.
1. Проверяем, что контейнеры запустились командой ``` docker-compose ps ```.
1. Запускаем приложение и передаем данные для подключения базы MySql командой (через командную строку)
   ``` java  -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -jar artifacts/aqa-shop.jar```   
1. Запускаем тесты командой (через run anything)
``` gradlew clean test -Durl="jdbc:mysql://localhost:3306/app" --info ```.
1. Формируем отчет командой ``` gradlew allureServe ```.
1. Оцениваем результаты тестирования.

## Процедура запуска тестов сервиса покупки путешествий для PostgreSQL
1. Клонируем [репозиторий](https://github.com/balrom1981/Diplom) на свой компьютер.
1. Открываем его с помощью JetBrains IntelliJ IDEA Ultimate.
1. Запускаем контейнеры PostgreSQL и Node c помощью команды
   ``` docker-compose up -d --force-recreate ```.
1. Проверяем, что контейнеры запустились командой ``` docker-compose ps ```.
1. Запускаем приложение и передаем данные для подключения базы PostgreSQL командой (через командную строку)
   ``` java  -Dspring.datasource.url=jdbc:postgresql://localhost:5432/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -jar artifacts/aqa-shop.jar```
1. Запускаем тесты командой (через run anything)
   ``` gradlew clean test -Durl="jdbc:mysql://localhost:3306/app" --info ```.
1. Формируем отчет командой ``` gradlew allureServe ```.
1. Оцениваем результаты тестирования.
