## Ссылки: 
1. [План тестирования](https://github.com/balrom1981/Diplom/blob/master/myreports/Plan.md).
1. 
1. 

## Процедура запуска тестов сервиса покупки путешествий для MySql
1. Клонируем [репозиторий](https://github.com/balrom1981/Diplom) на свой компьютер.
1. Открываем его с помощью JetBrains IntelliJ IDEA Ultimate.
1. Запускаем контейнеры MySql и Node c помощью команды 
``` docker-compose up -d --force-recreate ```.
1. Проверяем, что контейнеры запустились командой ``` docker-compose ps ```.
1. Запускаем приложение и передаем данные для подключения базы MySql командой
   ``` java  -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -Dspring.datasource.username=user -Dspring.datasource.password=pass -jar artifacts/aqa-shop.jar```   
1. Запускаем тесты командой
``` gradlew clean test -Durl="jdbc:mysql://localhost:3306/app" -Duser="user" -Dpassword="pass" --info ```.
1. Формируем отчет командой ``` gradlew allureServe ```.
1. Оцениваем результаты тестирования.

## Процедура запуска тестов сервиса покупки путешествий для PostgreSQL
1. Клонируем [репозиторий](https://github.com/balrom1981/Diplom) на свой компьютер.
1. Открываем его с помощью JetBrains IntelliJ IDEA Ultimate.
1. Запускаем контейнеры PostgreSQL и Node c помощью команды
   ``` docker-compose up -d --force-recreate ```.
1. Проверяем, что контейнеры запустились командой ``` docker-compose ps ```.
1. Запускаем приложение и передаем данные для подключения базы PostgreSQL командой
   ``` java  -Dspring.datasource.url=jdbc:postgresql://localhost:5432/appps -Dspring.datasource.username=userps -Dspring.datasource.password=passps -jar artifacts/aqa-shop.jar```
1. Запускаем тесты командой
   ``` gradlew clean test -Durl="jdbc:postgresql://localhost:5432/appps" -Duser="userps" -Dpassword="passps" --info ```.
1. Формируем отчет командой ``` gradlew allureServe ```.
1. Оцениваем результаты тестирования.
