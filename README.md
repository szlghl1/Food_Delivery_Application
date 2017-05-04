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

It is hard to describe the structure of parameter/return value before we define the fields of classes.

1. Restaurant

   1. foo.com/restaurants/[id]

      1. POST create a restaurant by passing name, description, the list of menu id (nullable), address

      2. GET get id, name, description, the list of menu id, address of restaurant

      3. PUT update info of restaurants. Request includes all fields restaurants have

   2. foo.com/menus

      1. POST create a menu

      2. GET return menu info

   3. foo.com/menus/[id]

      1. PUT modify menu info

   3. foo.com/menu_items/[id]

      1. GET menu items by menu id

2. Order

   1. foo.com/orders

      1. POST create an order by passing the list of menu items’ id, address and notes. It returns failure by http status or order id (success)

   2. foo.com/orders/[id]

      1. GET query info

      2. DELETE cancel an order

      3. PUT modify an order

3. Payment

   1. foo.com/payment

      1. POST create a payment by passing order number. If succeed, the service should notify order service

   2. foo.com/payment/[id]

      1. GET Return isSucceeded

## Guide to upload data

The basic idea is: upload top down in hierarchy.

1. Upload restaurants and get the id from response.

2. Upload menus with the restaurant id they belong to and get the menu id from respons.

3. Upload menu items with the menu id they belong to.

