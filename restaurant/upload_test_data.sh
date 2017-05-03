#!/bin/bash
cd "$(dirname "$0")"

curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d @Restaurants.json http://localhost:9002/restaurants
sleep 1

curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d @Menus.json http://localhost:9002/menus
sleep 1

curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d @MenuItems.json http://localhost:9002/menu_items