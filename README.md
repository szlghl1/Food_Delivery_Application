# Food Delivery Application
Searching restaurants, getting menus, ordering foods and paying for an order.

## Functions:

1. Search a restaurant by name

2. Order food by choosing menu items, quantity and adding a note.

3. User can also fills in delivery address.

4. User should be able to pay.

## Services:

The application is built on micro-service design. The application consists of three modules.

1. Restaurant

   * You can search restaurant, get menu of it here.

2. Order

   * You can place your order here.

3. Payment

   * You can pay your order here.

## APIs summary:

1. Restaurant

   1. Query restaurant by name

   2. Query menu by restaurant’s ID

   3. Query menu items by menu’s ID

2. Order

   1. Place an order & Return order number

   2. Query estimate delivery time

3. Payment

   1. Pay for an order & Return payment ID, timestamp or failure status

   2. Send a message to order service when succeed

## Flow:

Query restaurant -> query menu -> query menu items -> place order -> pay the bill -> payment service notify order service

## Database:

1. Restaurant

   1. Relational database

   2. Three table - because they are one to many and we can query restaurant info without querying its menu

2. Order

   1. mongoDB
   
   2. The reason I used mongoDB is an order can have various number of items in it.

3. Payment

   1. Relational database (structured, query by id)

## APIs details:

The format of POST request can be found in the test data (Restaurants.json, Orders.json, Payments.json)

1. Restaurant
   
    1. foo.com/restaurants
        
        1. GET passing page and size (optional) as parameters and get list of restaurants

        2. DELETE delete all restaurants
        
        3. POST upload a bunch of restaurants
        
    2. foo.com/restaurants/[id]

       1. GET get details of the restaurant
 
       2. DELETE delete the restaurant
       
       3. GET /restaurants/[id]/menus to get the menus of the restaurant
      
    3. foo.com/menus

       1. POST create a list of menus

       2. GET passing page and size (optional) as parameters and get list of menus
       
       3. DELETE delete all menus

    4. foo.com/menus/[id]

       1. GET get info of the menu
       
       2. DELETE delete a menu

    5. foo.com/menu_items
       
       1. GET passing page and size (optional) as parameters and get list of menu items
       
       2. POST upload a list of menu items
       
       3. DELETE delete all menu items
 
    3. foo.com/menu_items/[id]

       1. GET menu items by menu id
       
       2. DELETE delete a menu item
       
       3. GET /menu_items/[id]/price to get the price of it

2. Order

   1. foo.com/orders

      1. POST create a list of orders
      
      2. GET passing page and size (optional) as parameters and get list of orders

   2. foo.com/orders/[id]

      1. GET query info
   
   3. foo.com/orders/[id]/is_paid
   
      1. GET get if the order is paid
      
      2. PUT set if it is paid
   
   4. foo.com/orders/[id]/is_cancelled
   
      1. GET get if the order is cancelled
      
      2. PUT set if it is cancelled

3. Payment

   1. foo.com/payment

      1. GET passing page and size (optional) as parameters and get list of payments
      
      2. POST create a payment
      
   2. foo.com/payment/[id]

      1. GET Return its info

## Guide to upload data with cascading relation

The basic idea is: upload top down in hierarchy.

1. Upload restaurants and get the id from response.

2. Upload menus with the restaurant id they belong to and get the menu id from respons.

3. Upload menu items with the menu id they belong to.

## Order to run

launch restaurant -> upload test data -> launch order -> upload test data -> launch payment

Please note that because we cannot predict id generated by MongoDB, the test data of payment cannot let any order change to payed. The order service will only log a request try to set an inexistent order to payed.