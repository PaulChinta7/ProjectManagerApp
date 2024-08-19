# ProjectManagerApp

## How to Run - This project is dockerized.

```
git clone git@github.com:PaulChinta7/ProjectManagerApp.git
cd backend
docker-compose up --build
open in any browswer-> http://localhost:3000
```

## FrontEnd 
**ReactJS** : Used to create Web pages to fetch and render data onto the web pages.

![ProductManagerProducts](https://github.com/user-attachments/assets/2f4011e7-3ffc-45c5-9525-26479ec72b58)
![ProductManagerProductsForm](https://github.com/user-attachments/assets/831fbee3-9a11-4419-a668-253cd9b772c8)




## BackEnd
**Microservice 1**  - *`Product Service`* : Java SpringBoot , Kafka.
* products/addProduct
* products/addProducts
* products/delete
* products/update

**Microservice 2** - *`Update Service`* : Java SpringBoot , Kafka.
* **KafkaConsumerService** will accept the messages sent to the topic and update price in the database.







