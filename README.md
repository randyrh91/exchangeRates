Быстрый старт:

Сервис Exchange Rates - это простой проект. В следующем руководстве показаны шаги по подключению к службе и получению предоставляемой ею информации.

Exchange Rates Endpoint:

Exchange Rates получает доступ к сервису обменных курсов (OpenExchangeRates) и отдает gif в ответ:

- Если обменный курс валюты по отношению к базовой валюте на сегодня стал выше, чем вчера, то отдаем вам случайный gif отсюда https://giphy.com/search/rich
- Eсли ниже - отсюда https://giphy.com/search/broke

Определение:

http://localhost:8080/apiexchangerates/

Переменные:

base:	String (Необязательный)
Обмен базовой валюты (3-буквенный код, по умолчанию: RUB-российские рубли)

symbol:	String
Конкретные валюты ((3-буквенный код))

Валюты

В следующем URL вы можете получить доступ к списку символов валют , которые могут быть использованы.

https://openexchangerates.org/api/currencies.json

Пример:

http://localhost:8080/apiexchangerates/?base=USD&symbol=RUB

Результат примера

{
  "disclaimer": "Usage subject to terms: https://openexchangerates.org/terms",
  "license": "https://openexchangerates.org/license",
  "base": "USD",
  "rate": {
    "symbol": "RUB",
    "yesterday": "72.0042",
    "today": "71.4079"
  },
  "gif": {
    "id": "RHJwudDaoMPVmVjto2",
    "type": "gif",
    "title": "Imagine Credit Card GIF by INTO ACTION",
    "username": "IntoAction",
    "source": "",
    "url": "https://giphy.com/gifs/IntoAction-imagine-rent-cant-pay-RHJwudDaoMPVmVjto2",
    "images": {
      "original": {
        "url": "https://media1.giphy.com/media/RHJwudDaoMPVmVjto2/giphy.gif?cid=460955dc5359e2272cab4ad2436b257f363c82662835f960&rid=giphy.gif&ct=g",
        "height": "480",
        "width": "480",
        "size": "1562064"
      }
    }
  }
}
