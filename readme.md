# Camel Demo

Camel is a lightweight framework that integrates different data formats.
It subscribes and observes endpoints of different formats and passes
along messages after translating the data as necessary. 

### Demo Setup

ActiveMQ
```
docker pull rmohr/activemq
docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
```

Open localhost:8161 and create a queue named "send_queue"