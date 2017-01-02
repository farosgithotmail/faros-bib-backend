FROM frolvlad/alpine-oraclejdk8:slim
EXPOSE 8080
VOLUME /tmp
ADD /target/bib.backend-1.0-SNAPSHOT.jar bib.backend-1.0-SNAPSHOT.jar
RUN sh -c 'touch /bib.backend-1.0-SNAPSHOT.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /bib.backend-1.0-SNAPSHOT.jar" ]