# Supported tags and respective `Dockerfile` links

[`1.16.0`](https://github.com/FEISystems/phr-api/blob/master/phr/src/main/docker/Dockerfile),[`latest`](https://github.com/FEISystems/phr-api/blob/master/phr/src/main/docker/Dockerfile)[(1.16.0/Dockerfile)](https://github.com/FEISystems/phr-api/blob/master/phr/src/main/docker/Dockerfile)

For more information about this image, source code and its history, please see [GitHub repo](https://github.com/FEISystems/phr-api).

# What is PHR?

The Patient Health Record (PHR) API is responsible for storing patient identities in the Consent2Share domain, and for serving patient health records from Health Information Exchange (HIE) via Information Exchange Hub (IExHub). Currently, only patient demographics and consent2share Medical Record Numbers (MRN) are persisted in PHR domain.

For more information and related downloads for Consent2Share, please visit [Consent2share](https://feisystems.github.io/consent2share/).

# How to use this image


## Start a PHR instance

Be sure to familiarize yourself with the repository's [README.md](https://github.com/FEISystems/phr-api) file before start instance.

`docker run  --name phr -d bhits/phr:latest <additional program arguments>`

*NOTE: In order for this API to fully function as a microservice in consent2share Application, it is also required to setup the dependency microservices and support level infrastructure. Please refer to the [consent2share Deployment Guide]() for instructions to setup the consent2share infrastructure.*


## Configure

This API runs with some [default configuration](https://github.com/FEISystems/phr-api/blob/master/phr/src/main/resources/application.yml) that is primarily targeted for development environment.  Spring profile `docker` is actived by default when building images. [Spring Boot](https://projects.spring.io/spring-boot/) supports several methods to override the default configuration to configure the API for a certain deployment environment. 

Here is example to override default database password:

`docker run -d bhits/phr:latest --spring.datasource.password=strongpassword`


## Using a custom configuration file

To use custom `application.yml`, mount the file to docker container and setup `spring.config.location` to folder.

`docker run -e spring.config.location="file:/java/C2S_PROPS/phr/"  -v "/path/on/dockerhost/C2S_PROPS/phr/application.yml:/java/C2S_PROPS/phr/application.yml" -d bhits/phr:tag`

## Enviroment Variable

When you start the phr image, you can adjust the configuration of the phr instance by passing one or more environment variables on the docker run command line. 

### JAVA_OPTS 
This environment variable is used to setup JVM argument, such as memory configuration.
`docker run --name phr -e "JAVA_OPTS=-Xms512m -Xmx700m -Xss1m" -d bhits/phr:latest`

# Supported Docker versions
This image is officially supported on Docker version 1.12.1.

Support for older versions (down to 1.6) is provided on a best-effort basis.

Please see [the Docker installation documentation](https://docs.docker.com/engine/installation/) for details on how to upgrade your Docker daemon.

# License
View [license]() information for the software contained in this image.

# User Feedback

## Documentation 
Documentation for this image is stored in the [consent2share/phr-api](https://github.com/FEISystems/phr-api) GitHub repo. Be sure to familiarize yourself with the repository's README.md file before attempting a pull request.

## Issues

If you have any problems with or questions about this image, please contact us through a [GitHub issue](https://github.com/FEISystems/phr-api/issues).

