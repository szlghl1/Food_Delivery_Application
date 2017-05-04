#!/bin/bash
cd "$(dirname "$0")"

curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d @Orders.json http://localhost:9000/orders