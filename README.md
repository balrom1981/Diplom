## Процедура запуска тестов сервиса покупки путешествий
1. Клонировать [репозиторий](https://github.com/balrom1981/Diplom) на свой компьютер.
1. Открыть его с помощью JetBrains IntelliJ IDEA Ultimate.
1. Запустить контейнеры MySql и Node c помощью команды docker-compose up -d --force-recreate --build.
1. Проверить, что контейнеры запустились командой docker-compose ps.
1. Проверить командой docker-compose logs -f mysql (docker-compose logs -f node-app) готовность MySql (Node).
1. Запустить приложение командой java -jar artifacts/aqa-shop.jar.
1. Запустить тесты в тестовых классах MainPageTest и SqlTest. 
1. Оценить результаты тестерования.
