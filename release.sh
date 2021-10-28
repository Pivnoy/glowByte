#!/bin/bash
mvn install 1>logs.txt 2>errors.txt
chmod +x mvnw
./mvnw spring-boot:run 1>>logs.txt 2>>errors.txt &
