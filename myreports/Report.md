# Отчёт о тестировании.
## Краткое описание

Дата начала тестирования - 05.04.2021

Дата окончания тестирования - 23.04.2021

Было проведено тестирование комплексного сервиса покупки "Путешествия дня", взаимодействующего с СУБД и API Банка.

На тестирование затрачено: часа

## Описание процесса тестирования
В процессе тестирования было произведена настройка окружения взаимодействия сервиса покупки с СУБД и API банка и проведено тестироание:

* 32 кейса
* 20 успешных тест кейсов (63%) / 12 неуспешных тест кейсов (37%)

В результате тестирования выявлены следующие дефекты:

1. https://github.com/balrom1981/Diplom/issues/2
1. https://github.com/balrom1981/Diplom/issues/3
1. https://github.com/balrom1981/Diplom/issues/4
1. https://github.com/balrom1981/Diplom/issues/5
1. https://github.com/balrom1981/Diplom/issues/6
1. https://github.com/balrom1981/Diplom/issues/7

В процессе тестирования использовались следующие артефакты:
* JetBrains IntelliJ IDEA Ultimate
* Java, версия 11
* Gradle
* JUnit5
* Selenide
* MySQL
* PostgreSQL
* Docker
* Allure
* Lombok
* Faker

## Вывод:
По результатам тестирования было выявлено 6 дефектов характерных как для обычной покупки, так и для покупки в кредит. Большинство дефектов не являются критичными, не несут финансовых и репутационных потерь, увеличивают нагрузку СУБД и API банка. Дефект номер [три](https://github.com/balrom1981/Diplom/issues/4) является критичным, так как влечет за собой финансовые и репутационные потери и должен быть исправлен в первую очередь.

**В качестве тестовых данных использовались данные:**
[Дипломный проект профессии «Тестировщик»](https://github.com/netology-code/qa-diploma)

**Тестирование производилось в следующем окружении:**

OC Windows 10 Pro

64-bit Operation System, x64-based processor

Java version "11.0.9.1" 2020-11-04