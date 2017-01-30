# Short Description
Patient Health Record (PHR) API is responsible for storing patient identities in Consent2Share.

# Full Description

# Supported Tags and Respective `Dockerfile` Links

[`1.22.0`](https://github.com/bhits/phr-api/blob/master/phr/src/main/docker/Dockerfile),[`latest`](https://github.com/bhits/phr-api/blob/master/phr/src/main/docker/Dockerfile)[(1.22.0/Dockerfile)](https://github.com/bhits/phr-api/blob/master/phr/src/main/docker/Dockerfile)

For more information about this image, the source code, and its history, please see the [GitHub repository](https://github.com/bhits/phr-api).

# What is PHR?

The Patient Health Record (PHR) API is responsible for storing patient identities in the Consent2Share domain, and for serving patient health records from health information exchange (HIE) via the Information Exchange Hub (IExHub). Currently, only patient demographics and Consent2Share Medical Record Numbers (MRN) are persisted in PHR domain.

For more information and related downloads for Consent2Share, please visit [Consent2Share](https://bhits.github.io/consent2share/).
# How to use this image


## Start a PHR instance

Be sure to familiarize yourself with the repository's [README.md](https://github.com/bhits/phr-api) file before starting the instance.

`docker run  --name phr -d bhits/phr:latest <additional program arguments>`

*NOTE: In order for this API to fully function as a microservice in the Consent2Share application, it is required to setup the dependency microservices and support level infrastructure. Please refer to the [Consent2Share Deployment Guide](https://github.com/bhits/consent2share/releases/download/2.1.0/c2s-deployment-guide.pdf) for instructions to setup the Consent2Share infrastructure.*


## Configure

This API runs with a [default configuration](https://github.com/bhits/phr-api/blob/master/phr/src/main/resources/application.yml) that is primarily targeted for the development environment.  The Spring profile `docker` is actived by default when building images. [Spring Boot](https://projects.spring.io/spring-boot/) supports several methods to override the default configuration to configure the API for a certain deployment environment. 

Here is example to override default database password:

`docker run -d bhits/phr:latest --spring.datasource.password=strongpassword`

## Using a custom configuration file

To use custom `application.yml`, mount the file to the docker host and set the environment variable `spring.config.location`.

`docker run -v "/path/on/dockerhost/C2S_PROPS/phr/application.yml:/java/C2S_PROPS/phr/application.yml" -d bhits/phr:tag --spring.config.location="file:/java/C2S_PROPS/phr/"`

## Environment Variables

When you start the PHR image, you can edit the configuration of the PHR instance by passing one or more environment variables on the command line. 

### JAR_FILE

This environment variable is used to setup which jar file will run. you need mount the jar file to the root of container.

`docker run --name phr -e JAR_FILE="phr-latest.jar" -v "/path/on/dockerhost/phr-latest.jar:/phr-latest.jar" -d bhits/phr:latest`

### JAVA_OPTS 

This environment variable is used to setup JVM argument, such as memory configuration.

`docker run --name phr -e "JAVA_OPTS=-Xms512m -Xmx700m -Xss1m" -d bhits/phr:latest`

### DEFAULT_PROGRAM_ARGS 

This environment variable is used to setup application arugument. The default value of is "--spring.profiles.active=docker".

`docker run --name phr -e DEFAULT_PROGRAM_ARGS="--spring.profiles.active=ssl,docker" -d bhits/phr:latest`

# Supported Docker versions

This image is officially supported on Docker version 1.12.1.

Support for older versions (down to 1.6) is provided on a best-effort basis.

Please see the [Docker installation documentation](https://docs.docker.com/engine/installation/) for details on how to upgrade your Docker daemon.

# License

View [license](https://github.com/bhits/phr-api/blob/master/LICENSE) information for the software contained in this image.

# User Feedback

## Documentation 

Documentation for this image is stored in the [bhits/phr-api](https://github.com/bhits/phr-api) GitHub repository. Be sure to familiarize yourself with the repository's README.md file before attempting a pull request.

## Issues

If you have any problems with or questions about this image, please contact us through a [GitHub issue](https://github.com/bhits/phr-api/issues).