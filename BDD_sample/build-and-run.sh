#!/bin/bash
LABEL=$(date +'%Y%m%d-%H%M%S')
mvn clean package && docker build -t cucum_project/BDD_sample:$LABEL .
docker rm -f BDD_sample || true && docker run -it --rm -p 8080:8080 -p 4848:4848 --name BDD_sample cucum_project/BDD_sample:$LABEL
