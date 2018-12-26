#!/bin/bash

docker build -t  hello2:v1  --build-arg servicename=Hello2 .
