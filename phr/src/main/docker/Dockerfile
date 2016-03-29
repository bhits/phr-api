FROM java:8
ARG finalName
ADD $finalName /phr.jar
ENTRYPOINT ["java","-Djavax.net.ssl.trustStore=/java/keystore/mhc.keystore","-Djavax.net.ssl.trustStorePassword=changeit","-jar","/phr.jar","--spring.profiles.active=docker"]