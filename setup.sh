#!/bin/bash
./gradlew clean build

cp sample-eureka-server/build/libs/*.jar docker-files

cp spring-boot-app/build/libs/*.jar docker-files

cp sample-zuul-server/build/libs/*.jar docker-files

cd docker-files

docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

docker build -f docker-eureka . -t microservices/eureka-server:latest

docker build -f docker-account . -t microservices/account:latest

docker build -f docker-zuul . -t microservices/zuul:latest

rm *.jar

docker run -d --name eureka -p 8761:8761 microservices/eureka-server:latest

docker run -d --name account -p 8080:8080 -e EUREKA_URI="http://192.168.99.100:8761/eureka" microservices/account:latest

docker run -d --name juul -p 8090:8090 -e EUREKA_URI="http://192.168.99.100:8761/eureka" microservices/zuul:latest
