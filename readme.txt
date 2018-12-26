#Build docker image:
docker build -t  sunil36/hello2:v1  --build-arg servicename=Hello2 .

# Push docker image to docker hub on repository sunil36/hello2 with tag name v1:
docker push sunil36/hello2:v1

# Pull image from Docker hub:
docker pull sunil36/hello2:v1

# Run container:

Interactive mode = docker run --name hello2_v1 -it -p 9002:9002 -e ENVIRONMENT=dev  --rm sunil36/hello2:v1
Detached mode    = docker run --name hello2_v1 -it -p 9002:9002 -e ENVIRONMENT=dev -d  sunil36/hello2:v1
