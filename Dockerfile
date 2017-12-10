FROM java:8-jdk-alpine

COPY build/distributions/dashboard-service.zip /usr/lib/adscoop/dashboard-service.zip

RUN apk update && apk upgrade
RUN apk add bash

RUN cd /usr/lib/adscoop/ && unzip dashboard-service.zip
RUN rm /usr/lib/adscoop/dashboard-service.zip

EXPOSE 8185
