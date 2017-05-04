#!/bin/bash
cd "$(dirname "$0")"

curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d @Payments.json http://localhost:9001/payments