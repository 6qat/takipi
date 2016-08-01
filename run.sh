#!/bin/sh

# Builds the takipi docker base image, which contains TakipiAgent (look Dockerfile)
docker build -t takipi-base-image .

# Builds the app docker image, based on previous generated docker image (look above)
sbt docker:publishLocal

docker run --name app -d takipi-app:1.0
