# E-commerce Application API
This is an Individual project, I have worked on rest API service for an e-commerse Application in around 6-7 days. This service provides users to register and login, view/add products, and add to cart & order.

## Entity Relationship Diagram

[![ER Diagram](https://github.com/faterenuka/e-commerce-app/blob/main/Images/ER%20Diagram.png?raw=true)](https://github.com/faterenuka/e-commerce-app/blob/main/Images/ER%20Diagram.png?raw=true)


# Functionalities
-   User can register/login
-   See all products
-   Find products by category
-   Add to cart/edit into the cart
-   Place Order


## Backend Work
-  Proper Exception Handling
-  Proper Input Validation
-   Data Stored in the database(mySQL)
-   SignUp and Login

## Installation and Run
-  You can clone this repo and start the serve on localhost
-   Before running the API server, we should update the database config inside the application.properties file.
-   Update the port number, username and password as per our local database config.
```
server.port=8088
spring.datasource.url=jdbc:mysql://localhost:3306/ecommercedb
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=**YourPassword**
spring.jpa.hibernate.ddl-auto=update
```
# Tech Stacks

-   Java Core
-   Spring Data JPA
-   Spring Boot
-   Hibernate
-   MySQL

### Customer
```
{
  "id": 19,
  "firstName": "Om",
  "lastName": "Patil",
  "mobileNo": "6734216690",
  "password": "bfdd41a07db3dcf651c1960cbfa3f11de8ad3d78e577cf0659080b0b3b7193a3",
  "address": {
    "id": 18,
    "streetNo": "S9",
    "buildingName": "Shanti",
    "city": "Pune",
    "state": "MH",
    "country": "India",
    "pincode": "456789"
  },
  "email": "om@mail.com"
}

 User Login
 
{
  "uuid": "LAAn",
  "customerId": 19,
  "date": "2023-04-23T16:49:04.5610266"
}
```

### Product
```
{
  "id": 21,
  "productName": "SunCreem",
  "price": 150,
  "color": "Yellow",
  "specification": "ph50",
  "manufactorer": "Joy LTD",
  "productQuantity": 1000,
  "category": {
    "categoryId": 20,
    "categoryName": "Beauty"
  }
}
```
### Cart
```
{
  "id": 22,
  "customer": {
    "id": 19
  },
  "orderDetails": [
    {
      "id": 23,
      "product": {
        "id": 21,
        "productName": "SunCreem",
        "price": 150,
        "color": "Yellow",
        "specification": "ph50",
        "manufactorer": "Joy LTD",
        "productQuantity": 1000,
        "category": {
          "categoryId": 20,
          "categoryName": "Beauty"
        }
      },
      "quantity": 50,
      "totalPrice": 7500
    }
  ]
}
```
### Orders
```
{
  "orderId": 24,
  "date": "2023-04-23",
  "orderStatus": "placed",
  "orderDetails": [
    {
      "id": 23,
      "product": {
        "id": 21,
        "productName": "SunCreem",
        "productQuantity": 950,
        "category": {
          "categoryId": 20,
          "categoryName": "Beauty"
        }
      },
      "quantity": 50,
      "totalPrice": 7500
    }
  ],
  "customer": {
    "id": 19
  }
}
```

# Backend

## Swagger UI

## Customer-Controller
[![SwaggerUI](https://github.com/faterenuka/e-commerce-app/blob/main/Images/CustomerController.png?raw=true)](https://github.com/faterenuka/e-commerce-app/blob/main/Images/CustomerController.png?raw=true)

## User-Controller
[![SwaggerUI](https://github.com/faterenuka/e-commerce-app/blob/main/Images/UserLoginController.png?raw=true)](https://github.com/faterenuka/e-commerce-app/blob/main/Images/UserLoginController.png?raw=true)

## Product-Controller
[![SwaggerUI](https://github.com/faterenuka/e-commerce-app/blob/main/Images/Product.png?raw=true)](https://github.com/faterenuka/e-commerce-app/blob/main/Images/Product.png?raw=true)

## Cart-Controller
[![SwaggerUI](https://github.com/faterenuka/e-commerce-app/blob/main/Images/Cart.png?raw=true)](https://github.com/faterenuka/e-commerce-app/blob/main/Images/Cart.png?raw=true)

## Order-Controller
[![SwaggerUI](https://github.com/faterenuka/e-commerce-app/blob/main/Images/Orders.png?raw=true)](https://github.com/faterenuka/e-commerce-app/blob/main/Images/Orders.png?raw=true)

## Thank You! Your Order is Placed : )
[![SwaggerUI](https://en.pimg.jp/077/437/469/1/77437469.jpg)](https://en.pimg.jp/077/437/469/1/77437469.jpg)
