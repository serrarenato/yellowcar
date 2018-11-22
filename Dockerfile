FROM openjdk:8-jre-alpine

ENV APP_TARGET target
ENV APP yellowcar.jar


RUN mkdir -p /opt
COPY ${APP_TARGET}/${APP} /opt
EXPOSE 8080
CMD java -jar /opt/${APP}



