FROM java:8
EXPOSE 8523

VOLUME /tmp
ADD /target/hisw-generator-1.0.0.jar /stupid-generator-1.0.0.jar
RUN bash -c 'touch /stupid-generator-1.0.0.jar'
ENTRYPOINT ["java","-jar","/stupid-generator-1.0.0.jar"]
