# Simple-crud
Проект элементарного CRUD приложения. 

Приложение запущено по адресу http://maltsev.fun/


<!--Блок информации о репозитории в бейджах-->
![Static Badge](https://img.shields.io/badge/opp2211-simple--crud-orange)
![GitHub top language](https://img.shields.io/github/languages/top/opp2211/simple-crud)
![GitHub](https://img.shields.io/github/license/opp2211/simple-crud)
![GitHub Repo stars](https://img.shields.io/github/stars/opp2211/simple-crud)
![GitHub issues](https://img.shields.io/github/issues/opp2211/simple-crud)


<!--Установка-->
## Установка

1. Клонирование репозитория 

```git clone https://github.com/opp2211/simple-crud.git```

2. Переход в директорию проекта

```cd simple-crud```

3. Необходимо создать в корне проекта .env файл и указать необходимые переменные среды, пример содержания файла:

```
DB_URL=jdbc:postgresql://db:5432/simple-crud
DB_USER=postgres
DB_PASSWORD=postgres
```

4. Запуск через Docker compose

```docker compose up -d --build```
