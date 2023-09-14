Для запуска данного REST API, установите Java 17 и Spring Boot 2+. Затем склонируйте репозиторий из публичного GitHub репозитория и выполните команду: 
    
    ./mvnw clean package
    java -jar target/testTaskFomT1Consulting.jar

Формат входных параметров: 

API ожидает входной параметр input, который представляет собой строку, для которой нужно вычислить частоту встречи символов.

Формат исходящих параметров: 

API возвращает результат в виде JSON-объекта, где ключом является символ, а значением - количество вхождений символа в заданную строку. Результат отсортирован по убыванию количества вхождений символа.

Пример запроса: 

    GET /api/frequency?inputString=aaaaabcccc
    GET /api/json?inputString=aaaaabcccc

Пример ответа:

    “a”: 5, “c”: 4, “b”: 1

    {
        “a”: 5,
        “c”: 4,
        “b”: 1
    }
