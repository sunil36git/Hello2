#!/bin/bash

docker run -it -p 9002:9002 -e ENVIRONMENT=dev  --name hello2 hello2
