# Сервис перевода денег
API для перевода денег с карты на карту.

### Описание
REST-интерфейс для интеграции с FRONT. Реализует методы, описанные [в протоколе](https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml).
Подключение к API осуществляется по порту 5500.
Все операции логируются в файле resources/logs/log.txt.

### Запуск
Возможен запуск с помощью IDE или с помощью Docker.
Команда создания образа Docker:
>docker-compose build

Команда запуска Docker:
>docker-compose up

### Использование
POST-запросы в соответствии с [протоколом](https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml) по адресам:
* http://localhost:5500/transfer
* http://localhost:5500/confirmOperation

### Демонстрация работы
Запустите приложение и откройте пример FRONT по адресу: https://serp-ya.github.io/card-transfer/.