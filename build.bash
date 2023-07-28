#!/usr/bin/env bash

echo "Hello World!" 

echo "bash ./build.bash"

pwd
cd api
mvn clean compile package install

cd ../util
mvn clean compile package install

cd ../microservices/product-service
mvn clean compile package install

cd ..
cd review-service
mvn clean compile package install

cd ..
cd recommendation-service
mvn clean compile package install


cd ..
cd product-composite
mvn clean compile package install

cd ..
docker-compose build

echo 'Inside ------->>>>> ' "$PWD"

docker-compose down

docker-compose up -d
