FROM java:8
VOLUME /tmp
ADD target/itau-case-twitter-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Dserver.port=8090","-jar","/app.jar"]
