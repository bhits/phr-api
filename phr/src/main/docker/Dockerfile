FROM java:8
ADD phr-1.7.0-SNAPSHOT.jar /phr.jar
ENTRYPOINT ["java","-Djavax.net.ssl.trustStore=/java/keystore/mhc.keystore","-Djavax.net.ssl.trustStorePassword=changeit","-jar","/phr.jar"]